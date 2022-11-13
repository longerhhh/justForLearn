package org.example

import kotlin.reflect.KClass

// Booleans/EvaluationOrder.kt
class L: List<String> by listOf() {

}

interface I  {
    fun i()
}

interface I2 {
    fun i2()
}

interface I3 {
    fun i()
}

class B :   I {
    override fun i() {
        println(1)
    }
}

class D: I2 {
    override fun i2() {
        println(2)
    }
}

class E: I3 {
    override fun i() {
        println(3)
    }
}

class C @JvmOverloads constructor(private val b: B = B()): I by b, I2 by D(), I3 by E() {
    override fun i() {
        b.i()
    }
}

// Visibility/RecordAnimals.kt

private var index = 0                  // [1]

private class Animal(val name: String) // [2]

private fun recordAnimal(              // [3]
    animal: Animal
) {
    println("Animal #$index: ${animal.name}")
    index++
}

fun recordAnimals() {
    recordAnimal(Animal("Tiger"))
    recordAnimal(Animal("Antelope"))
}

fun recordAnimalsCount() {
    println("$index animals are here!")
}

// AtomicTest/AtomicTest.kt

const val ERROR_TAG = "[Error]: "

private fun <L, R> test(
    actual: L,
    expected: R,
    checkEquals: Boolean = true,
    predicate: () -> Boolean
) {
    println(actual)
    if (!predicate()) {
        print(ERROR_TAG)
        println("$actual " +
                (if (checkEquals) "!=" else "==") +
                " $expected")
    }
}

/**
 * Compares the string representation
 * of this object with the string `rval`.
 */
infix fun Any.eq(rval: String) {
    test(this, rval) {
        toString().trim() == rval.trimIndent()
    }
}

/**
 * Verifies this object is equal to `rval`.
 */
infix fun <T> T.eq(rval: T) {
    test(this, rval) {
        this == rval
    }
}

/**
 * Verifies this object is != `rval`.
 */
infix fun <T> T.neq(rval: T) {
    test(this, rval, checkEquals = false) {
        this != rval
    }
}

/**
 * Verifies that a `Double` number is equal
 * to `rval` within a positive delta.
 */
infix fun Double.eq(rval: Double) {
    test(this, rval) {
        kotlin.math.abs(this - rval) < 0.0000001
    }
}

/**
 * Holds captured exception information:
 */
class CapturedException(
    private val exceptionClass: KClass<out Throwable>?,
    private val actualMessage: String
) {
    private val fullMessage: String
        get() {
            val className =
                exceptionClass?.simpleName ?: ""
            return className + actualMessage
        }
    infix fun eq(message: String) {
        fullMessage eq message
    }
    infix fun contains(parts: List<String>) {
        if (parts.any { it !in fullMessage }) {
            print(ERROR_TAG)
            println("Actual message: $fullMessage")
            println("Expected parts: $parts")
        }
    }
    override fun toString() = fullMessage
}

/**
 * Captures an exception and produces
 * information about it. Usage:
 *    capture {
 *      // Code that fails
 *    } eq "FailureException: message"
 */
fun capture(f:() -> Unit): CapturedException =
    try {
        f()
        CapturedException(null,
            "$ERROR_TAG Expected an exception")
    } catch (e: Throwable) {
        CapturedException(e::class,
            (e.message?.let { ": $it" } ?: ""))
    }

/**
 * Accumulates output when called as in:
 *   trace("info")
 *   trace(object)
 * Later compares accumulated to expected:
 *   trace eq "expected output"
 */
object trace {
    private val trc = mutableListOf<String>()
    operator fun invoke(obj: Any?) {
        trc += obj.toString()
    }
    /**
     * Compares trc contents to a multiline
     * `String` by ignoring white space.
     */
    infix fun eq(multiline: String) {
        val trace = trc.joinToString("\n")
        val expected = multiline.trimIndent()
            .replace("\n", " ")
        test(trace, multiline) {
            trace.replace("\n", " ") == expected
        }
        trc.clear()
    }
}

fun main() {
    tag@ for (i in 0..10) {
        for (j in 10..20) {
            if (j == 15) {
//                return@tag
            }
            println('a')
        }
    }
    listOf(1).forEach tagg@ {
        println(it)
        if (it == 2) {
            return@tagg
        }
    }

//    val s = generateSequence(0) { it+1 }
//    println(s.take(10).toSortedSet())
//    val items = mutableListOf(
//        "first", "second", "third", "XXX", "4th"
//    )
//    println(items)
//    val seq = generateSequence {
//        items.removeAt(0).takeIf { it != "XXX" }
//    }
//    println(seq.toList())
//    println(items)
//    println("4th" != "XXX")
//    val m =   mapOf(
//        1 to 1, 2 to 2, 3 to 3
//    )
//    println(m[1])
//    println(m[4])
//    m[4]?.also {
//        println(it)
//    }
//    m[1].also {
//
//    }

//    val poem = """
//    |->Last night I saw upon the stair
//        |->A little man who wasn't there
//          |->He wasn't there again today
//|->Oh, how I wish he'd go away."""
//    poem.trimMargin() eq
//            """->Last night I saw upon the stair
//->A little man who wasn't there
//->He wasn't there again today
//->Oh, how I wish he'd go away."""
//    poem.trimMargin(marginPrefix = "|->") eq
//            """Last night I saw upon the stair
//A little man who wasn't there
//He wasn't there again today
//Oh, how I wish he'd go away."""

//    1 eq 1
//    recordAnimals()
//    recordAnimalsCount()
//    recordAnimals()
//    recordAnimalsCount()
//    recordAnimalsCount()
//    C().i()
//    repeat(2) {
//        print('1')
//    }
//    println()
/*println(
        run {
            println(1)
            true
        } && run {
            println(2)
            false
        } || run {
            println(3)
            true
        } && run {
            println(4)
            false
        }
    )*/
}
/* Output:
true
true
false
*/