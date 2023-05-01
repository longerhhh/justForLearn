package com.example

fun main() {
    println(intToRoman(20))
}

fun intToRoman(num: Int): String {
    val kv = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )
    var n = num
    val sb = StringBuilder()
    while (n > 0) {
        for ((k, v) in kv) {
            if (n >= k) {
                n -= k
                sb.append(v)
                break
            }
        }
    }
    return sb.toString()
}
