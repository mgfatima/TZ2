import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ui.ApplicationFrame;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerformanceChart extends ApplicationFrame {

    public PerformanceChart(String applicationTitle, String chartTitle) throws IOException {
        super(applicationTitle);
        String[] csvFilePaths = {"_min_performance.csv", "_max_performance.csv", "_sum_performance.csv", "mult_performance.csv"};

        generateCSVFiles(csvFilePaths);

        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle,
                "Data size",
                "Execution time (ms)",
                createDataset(csvFilePaths),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(xylineChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        final XYPlot plot = xylineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);
        setContentPane(chartPanel);

        // Установим цвет и стиль линии для каждой серии данных
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        renderer.setSeriesPaint(3, Color.ORANGE);
        renderer.setSeriesStroke(3, new BasicStroke(2.0f));
    }

    private XYSeriesCollection createDataset(String[] csvFilePaths) throws IOException {
        XYSeriesCollection dataset = new XYSeriesCollection();
        String[] seriesNames = {"Min", "Max", "Sum", "Mult"};

        for (int i = 0; i < csvFilePaths.length; i++) {
            XYSeries series = new XYSeries(seriesNames[i]);
            try (BufferedReader br = new BufferedReader(new FileReader(csvFilePaths[i]))) {
                String line = br.readLine(); // Пропустить заголовок
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    int size = Integer.parseInt(values[0]);
                    long time = Long.parseLong(values[1]);
                    series.add(size, time);
                }
            }
            dataset.addSeries(series);
        }

        return dataset;
    }

    private List<Integer> generateNumbers(int size) {
        return IntStream.rangeClosed(1, size).boxed().collect(Collectors.toList());
    }

    private void measurePerformance(String methodName, PerformanceTester tester) throws IOException {
        try (FileWriter writer = new FileWriter(methodName + "_performance.csv")) {
            writer.write("Size,Time\n");

            for (int size = 1000; size <= 1000000; size *= 5) {
                List<Integer> numbers = generateNumbers(size);
                long startTime = System.currentTimeMillis();
                tester.test(numbers);
                long endTime = System.currentTimeMillis();
                writer.write(size + "," + (endTime - startTime) + "\n");
            }
        }
    }

    private void generateCSVFiles(String[] csvFilePaths) throws IOException {
        measurePerformance("_min", NumberProcessor::_min);
        measurePerformance("_max", NumberProcessor::_max);
        measurePerformance("_sum", NumberProcessor::_sum);
        measurePerformance("mult", NumberProcessor::mult);
    }

    @FunctionalInterface
    interface PerformanceTester {
        void test(List<Integer> numbers);
    }

    public static void main(String[] args) {
        try {
            PerformanceChart chart = new PerformanceChart(
                    "Performance Chart",
                    "Function execution time"
            );

            chart.pack();
            chart.setLocationRelativeTo(null); // Центрируем окно на экране
            chart.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
