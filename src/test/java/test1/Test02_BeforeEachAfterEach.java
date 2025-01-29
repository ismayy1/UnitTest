package test1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test02_BeforeEachAfterEach {

    String string;

    @BeforeEach
    void beforeEach() {
        string = "A value";
        System.out.println("beforeEach called.");
    }

    @AfterEach
    void afterEach() {
        string = null;
        System.out.println("afterEach called.");
    }

    @Test
    void testUppercase() {
        String actualVal = string.toUpperCase();
        String expectedVal = "A VALUE";

        assertEquals(expectedVal, actualVal);
    }

    @Test
    void testContains() {
        boolean actualVal = string.contains("a");
        boolean expectedVal = true;

        assertEquals(expectedVal, actualVal);

//        assertEquals(true, actualVal);
//        assertTrue(string.contains("a"));
    }
}
