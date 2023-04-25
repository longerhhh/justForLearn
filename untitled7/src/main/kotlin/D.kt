fun main() {
}

//fun convert(s: String, numRows: Int): String {
//}

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) {
        return s
    }
    val length = s.length
    // 生成间隔数组
    val distance = Array(numRows) { IntArray(2) }
    val d = (numRows - 1) * 2
    for (i in 0 until numRows) {
        distance[i][0] = d - 2 * i
        distance[i][1] = d - 2 * (numRows - 1 - i)
    }
    val sb = StringBuilder()
    var col = 0
    while (col < numRows && col < length) {
        var i = col
        var j = 0
        while (i < length) {
            sb.append(s[i])
            print(s[i])
            i += when (col) {
                0 -> {
                    distance[col][0]
                }

                numRows - 1 -> {
                    distance[col][1]
                }

                else -> {
                    distance[col][j % 2]
                }
            }
            j++
        }
        col++
    }
    println()
    return sb.toString()
}


fun reverse(x: Int): Int {
    val s = x.toString()
    val sb = StringBuffer()
    if (s[0] == '-') {
        sb.append('-')
        sb.append(s.subSequence(1..s.lastIndex).reversed())
    } else {
        sb.append(s.reversed())
    }
    return sb.toString().toLong().let { if (it !in Int.MIN_VALUE..Int.MAX_VALUE) 0 else it.toInt() }
}
