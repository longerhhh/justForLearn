/**
 * 最大子段
 */
fun main() {
    val a = intArrayOf(-9,5,8,-7,8,3,-1,-5,7)
    maxSubSum(a, 0, a.size)
}

fun maxSubSum(a: IntArray, s:Int, e:Int):Int {
    val m = (s+e)/2
    val l = maxSubSum(a,s,m)
    val r = maxSubSum(a,m,e)
    var l1 = 0
    var r1 = 0
    var s1 = 0
    var s2 = 0
    for (i in m-1 downTo 0) {
        l1 += a[i]
        if (l1 > s1) {
            s1 = l1
        }
    }
    for (i in m until e) {
        r1 += a[i]
        if (r1 > s2) {
            s2 = r1
        }
    }
    var s = s1 + s2
    if (s < l) {
        s = l
    }
    if (s < r) {
        s = r
    }
    return s
}
