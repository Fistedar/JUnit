import Calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Date;
import java.util.stream.Stream;

public class TestCalculator {
    private static Calculator calc;
    private static Date date;

    @BeforeAll
    public static void startTest() {
        date = new Date();
        calc = new Calculator();

        System.out.println("Начинаем проверку тестов " + date.toString());
    }

    @BeforeEach
    public void everyTest() {
        System.out.println("Тест начат");
    }

    @AfterAll
    public static void endTests() {
        System.out.println("Тесты закончены " + date.toString());
    }

    @AfterEach
    public void endEveryTest() {
        System.out.println("Тест выполнен");
    }

    @Test
    public void minusTest() {
        int result = calc.minus.apply(3, 2);
        int expected = 1;
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("source")
    public void multiply(int x, int y, int expected) {
        int result = calc.multiply.apply(x, y);
        Assertions.assertEquals(expected, result);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(5, 4, 20),
                Arguments.of(10, 5, 50));

    }
    

    @Test
    public void plusTest() {
        int result = calc.plus.apply(2, 5);
        int expected = 7;
        Assertions.assertEquals(expected, result);
    }
}
