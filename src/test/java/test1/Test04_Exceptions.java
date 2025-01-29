package test1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test04_Exceptions {

    @Test
    void testLengthThrowsException() {
        String string1 = "Hello World!";
        String string2 = null;

//        string2.length();   // NullPointerException

        assertThrows(NullPointerException.class, () -> {
            System.out.println("assertThrows called.");
            string2.length();
        });

        assertDoesNotThrow(string1::length);
    }

    @Test
    void testDivide() {
        int number1 = 1;
        int number2 = 0;

        assertThrows(ArithmeticException.class, () -> System.out.println(number1/number2));
    }
}
