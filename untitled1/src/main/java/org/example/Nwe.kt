package org.example

interface A {
    fun a()
}

interface F {
    fun f()
}

interface G {
    fun g()
}

interface H {
    fun h()
}

context(A, F)
fun aaaa() {
    a()
    f()
    val a = "asd f as df"
//    a[1..2]
    a[2]
    a-"as"
    a-'a'
    a-"fff"
    a.reversed()
    a.capitalize()
    a.replaceFirstChar { it.uppercase() }
    a.toInt()
    a.toIntOrNull()
}

operator fun String.minus(other: String) = replace(other, "")
operator fun String.minus(c: Char) = replace(c.toString(), "")

class N : A, F {
    override fun a() {
        println('a')
    }

    override fun f() {
        println('f')
    }
}

fun main() {
}