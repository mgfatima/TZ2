import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberProcessorTest {

    // Тест для метода _min
    @Test
    public void testMin() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        assertEquals(1, NumberProcessor._min(numbers));
    }

    // Тест для метода _max
    @Test
    public void testMax() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        assertEquals(9, NumberProcessor._max(numbers));
    }

    // Тест для метода _sum
    @Test
    public void testSum() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        assertEquals(23, NumberProcessor._sum(numbers));
    }

    // Тест для метода mult
    @Test
    public void testMult() {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9);
        assertEquals(540, NumberProcessor.mult(numbers));
    }
}
