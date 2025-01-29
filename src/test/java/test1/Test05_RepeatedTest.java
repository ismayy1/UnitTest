package test1;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test05_RepeatedTest {

    @RepeatedTest(5)
    void testSubString() {
        assertEquals("Java", "Java is nice.".substring(0, 4));
    }

    @RepeatedTest(5)
    void testAddExactRepeatedly() {
        Random random = new Random();

        int n1 = random.nextInt(100);
        int n2 = random.nextInt(100);

        assertEquals(n1 + n2, Math.addExact(n1, n2));

        System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
    }
}
