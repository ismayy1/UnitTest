package test1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test03_BeforeAllAfterAll {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeALl called.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll called.");
    }

    @Test
    void testSplit() {
        String[] actualVal = "JUnit is a unit test library.".split(" ");
        String[] expectedVal = {"JUnit", "is", "a", "unit", "test", "library."};

        assertArrayEquals(expectedVal, actualVal);
    }

    @Test
    void testMin() {
//        int actualVal = Math.min(8, 4);
//        int expectedVal = 4;
//
//        assertEquals(expectedVal, actualVal);
        assertEquals(4, Math.min(8, 4));
    }
}
