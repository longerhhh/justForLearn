/**
 * 归并排序
 */
fun main() {
    val a = intArrayOf(5, 8, 6, 3, 4, 9)
    mergeSort(a, 0, 5)
    println(a.contentToString())
}

fun mergeSort(a: IntArray, p:Int, q:Int) {
    if (p < q) {
        val r = (p + q) / 2
        mergeSort(a, p,r)
        mergeSort(a,r+1,q)
        // 合并两段排序
        merge(a, p, r,q)
        println("$p,$r,$q,${a.contentToString()}")
    }
}

fun merge(a: IntArray, p: Int, r: Int, q: Int) {
    val n1 = q-r+1
    val n2 = r-p
    val left = a.slice(0 until n1)
    val right = a.slice(n1 until q)
    var x = 0
    var y = 0
    for (i in 0 until q) {
        if (x >= left.size) {
            a[i] = right[y++]
        } else if(y >= right.size) {
            a[i] = left[x++]
        } else if (left[x] < right[y]) {
            a[i] = left[x++]
        } else {
            a[i] = right[y++]
        }
    }
}
