import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberProcessor {

    // Метод для чтения чисел из файла
    public static List<Integer> readNumbersFromFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return Arrays.stream(content.trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    // Метод для поиска минимального числа
    public static int _min(List<Integer> numbers) {
        return numbers.stream().min(Integer::compare).orElseThrow();
    }

    // Метод для поиска максимального числа
    public static int _max(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).orElseThrow();
    }

    // Метод для расчета суммы всех чисел
    public static long _sum(List<Integer> numbers) {
        return numbers.stream().mapToLong(Integer::longValue).sum();
    }

    // Метод для расчета произведения всех чисел
    public static long mult(List<Integer> numbers) {
        return numbers.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
    }

    // Основной метод для запуска программы
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = readNumbersFromFile("numbers.txt");
        System.out.println("Min: " + _min(numbers));
        System.out.println("Max: " + _max(numbers));
        System.out.println("Sum: " + _sum(numbers));
        System.out.println("Mult: " + mult(numbers));
    }
}
