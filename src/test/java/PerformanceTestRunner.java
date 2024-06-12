import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerformanceTestRunner {

    // Метод для генерации списка чисел заданного размера
    private List<Integer> generateNumbers(int size) {
        return IntStream.rangeClosed(1, size).boxed().collect(Collectors.toList());
    }

    // Тест производительности для метода _min
    @Test
    public void testMinPerformance() {
        for (int size = 1000; size <= 1000000; size *= 5) {
            List<Integer> numbers = generateNumbers(size);
            long startTime = System.currentTimeMillis();
            NumberProcessor._min(numbers);
            long endTime = System.currentTimeMillis();
            System.out.println("Execution time _min для " + size + " numbers: " + (endTime - startTime) + " ms");
        }
    }

    // Тест производительности для метода _max
    @Test
    public void testMaxPerformance() {
        for (int size = 1000; size <= 1000000; size *= 5) {
            List<Integer> numbers = generateNumbers(size);
            long startTime = System.currentTimeMillis();
            NumberProcessor._max(numbers);
            long endTime = System.currentTimeMillis();
            System.out.println("Execution time _max для " + size + " numbers: " + (endTime - startTime) + " ms");
        }
    }

    // Тест производительности для метода _sum
    @Test
    public void testSumPerformance() {
        for (int size = 1000; size <= 1000000; size *= 5) {
            List<Integer> numbers = generateNumbers(size);
            long startTime = System.currentTimeMillis();
            NumberProcessor._sum(numbers);
            long endTime = System.currentTimeMillis();
            System.out.println("Execution time _sum для " + size + " numbers: " + (endTime - startTime) + " ms");
        }
    }

    // Тест производительности для метода mult
    @Test
    public void testMultPerformance() {
        for (int size = 1000; size <= 1000000; size *= 5) {
            List<Integer> numbers = generateNumbers(size);
            long startTime = System.currentTimeMillis();
            NumberProcessor.mult(numbers);
            long endTime = System.currentTimeMillis();
            System.out.println("Execution time mult для " + size + " numbers: " + (endTime - startTime) + " ms");
        }
    }
}
