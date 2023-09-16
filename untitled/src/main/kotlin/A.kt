import kotlin.system.measureNanoTime

/**
 * 已知一个数字中任意两数之和，求出一个这两数的位置索引
 */
fun main() {
    val a = IntArray(10_000) { (1..1000_000).random() }
    val b = a.random() + a.random()
    println(measureNanoTime { f1(a, b) })
    println(measureNanoTime { f2(a, b) })
}

/**
 * 双层循环暴力求解
 */
fun f1(a: IntArray, b: Int): Pair<Int, Int> {
    for (i in a.indices) {
        for (j in i until a.size) {
            if (a[i] + a[j] == b) {
                return i to j
            }
        }
    }
    return -1 to -1
}

/**
 * 更优解法，在判断和是否满足的同时得到一个差，将之存入map，后续在map中查找条件是否满足
 * 一次迭代对比了两个值，性能更好
 */
fun f2(a: IntArray, b: Int): Pair<Int, Int> {
    val m = mutableMapOf<Int, Int>()
    for (i in a.indices) {
        val key = b - a[i]
        if (m.containsKey(key)) {
            return i to (m[key]?:-1)
        }
        m[key] = i
    }
    return -1 to -1
}