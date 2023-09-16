package org.example;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.MethodName.class) // default
//@TestMethodOrder(MethodOrderer.Random.class) // randomly based on method name
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    @Order(1)
    @Test
    @DisplayName("test if add method in DemoUtils is running correctly. 😊")
    void testAdd() {
        System.out.println("DemoUtilsTest.testAdd running");

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(7, demoUtils.add(2, 4), "2+4 must not be 8");
    }

    @Order(-1)
    @Test
    @DisplayName("test if check null in DemoUtils is running correctly. 😁")
    void testCheckNull() {
        System.out.println("DemoUtilsTest.testCheckNull running");

        assertNull(demoUtils.checkNull(null), "null must be null");
        assertNotNull(demoUtils.checkNull(5), "5 must not be null");
        assertNotNull(demoUtils.checkNull(""), "empty string must not be null");
    }

    @Order(5)
    @Test
    void testSameOrNot() {
        String str = "Luv2Code Academy";
        String s = new String("Luv2Code Academy");

        // strings are in constant pool in java, so same string refer to same reference.
        assertSame(str, demoUtils.getAcademy(), "academy from demoUtils and custom should refer to same object");
        // but if you new a String, it will refer to a new reference, not in the constant pool
        assertNotSame(s, demoUtils.getAcademy(), "academy from demoUtils and new should not refer to same object");
    }

    @Test
    void testTrue() {
        assertTrue(demoUtils.isGreater(2, 1), "2 is bigger than 1");
        assertFalse(demoUtils.isGreater(1, 2), "1 is not bigger than 2");
    }

    @Test
    void testArrayEquals() {
        String[] arr = {"A", "B", "C"};

        assertArrayEquals(arr, demoUtils.getFirstThreeLettersOfAlphabet(), "array should be the same");
    }

    @Test
    void testIterableEquals() {
        List<String> list = List.of("luv", "2", "code");

        assertIterableEquals(list, demoUtils.getAcademyInList(), "expected list should be the same as actual list");
    }

    @Test
    void testLinesMatch() {
        List<String> list = List.of("luv", "2", "code");

        assertLinesMatch(list, demoUtils.getAcademyInList(), "lines should match");
    }

    @Test
    void testThrows() {
        assertThrows(IllegalArgumentException.class, () -> demoUtils.throwException(-1), "show throw illegal argument exception");
        assertDoesNotThrow(() -> demoUtils.throwException(0), "should not throw exception");
    }

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofSeconds(3), () -> demoUtils.checkTimeout());
    }

    @Test
    void testTimeoutPreemptively() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> demoUtils.checkTimeout());
    }
}