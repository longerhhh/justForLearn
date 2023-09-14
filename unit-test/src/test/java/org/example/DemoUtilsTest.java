package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAdd() {
        DemoUtils demoUtils = new DemoUtils();

        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6");
        assertNotEquals(7, demoUtils.add(2,4), "2+4 must not be 8");
    }

    @Test
    void testCheckNull() {
        DemoUtils demoUtils = new DemoUtils();

        assertNull(demoUtils.checkNull(null), "null must be null");
        assertNotNull(demoUtils.checkNull(5), "5 must not be null");
        assertNotNull(demoUtils.checkNull(""), "empty string must not be null");
    }
}