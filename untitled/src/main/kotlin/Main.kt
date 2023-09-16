import kotlin.system.measureNanoTime

fun main() {
    val map = mutableMapOf<String, Int>()
    val a by map
//    println(a)
    map["a"] = 1
    map["b"] = 2
    val b by map
    println(b)

    val q = IntArray(10_000) { (1..1000_000).random() }
    val w = IntArray(10_000) { (1..1000_000).random() }
    val s = q.random() + w.random()
    println("f1 = " + measureNanoTime { f1(q,w,s) })
    println("f2 = " + measureNanoTime { f2(q,w,s) })
}

fun f1(a: IntArray, b: IntArray, s: Int): Pair<Int, Int> {
    for (i in a.indices) {
        for (j in i until b.size) {
            if (a[i] +b[j]==s) return i to j
        }
    }
    return -1 to -1
}

fun f2(a: IntArray, b: IntArray, s: Int): Pair<Int, Int> {
    val sa = mutableMapOf<Int, Int>()
    for (i in a.indices) {
//        if (sa.containsValue(s - a[i])) return i to sa.fi
    }
    return -1 to -1
}

val MAP = Array(10) { IntArray(10) { 0 } }
val COLORS = intArrayOf(1, 2, 3, 4, 5, 6, 7)

fun fillColors(): Unit {

}