package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    private DemoUtils demoUtils;

    @BeforeEach
    void setUp() {
        // set up
        demoUtils = new DemoUtils();

        System.out.println("DemoUtilsTest.setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("DemoUtilsTest.tearDown");
        System.out.println();
    }

    @BeforeAll
    static void setupBeforeAllTest() {
        System.out.println("DemoUtilsTest.setupBeforeAllTest: One-time set up before all tests");
        System.out.println();
    }

    @AfterAll
    static void tearDownAfterAllTest() {
        System.out.println("DemoUtilsTest.tearDownAfterAllTest: One-time clean up after all tests");
    }

    @Test
    void testAdd() {
        System.out.println("DemoUtilsTest.testAdd running");

        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6");
        assertNotEquals(7, demoUtils.add(2,4), "2+4 must not be 8");
    }

    @Test
    void testCheckNull() {
        System.out.println("DemoUtilsTest.testCheckNull running");

        assertNull(demoUtils.checkNull(null), "null must be null");
        assertNotNull(demoUtils.checkNull(5), "5 must not be null");
        assertNotNull(demoUtils.checkNull(""), "empty string must not be null");
    }
}