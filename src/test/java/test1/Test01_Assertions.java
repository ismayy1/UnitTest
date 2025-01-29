package test1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Test01_Assertions {

    @Test
    public void test() {}

    @Test
    void testLength() {
        String string = "Hello World!"; // 12 chars long
        int actualVal = string.length();
        int expectedVal = 12;
        assertEquals(expectedVal, actualVal, "The length is incorrect!");
    }

    @Test
    void testAddExact() {
        int actualVal = Math.addExact(30, 70);
        int expectedVal = 100;
        int unExpectedVal = 101;
        assertEquals(expectedVal, actualVal);
        assertNotEquals(unExpectedVal, actualVal);
    }
}
