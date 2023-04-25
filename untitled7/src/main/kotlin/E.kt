import java.util.*

/**
 * 6 30
81 87 47 59 81 18

6 20
81 87 47 59 81 18

4 10
40 51 62 73
 */
fun main() {
//    D.pair(6,30, byteArrayOf(81, 87, 47, 59, 81, 18))
//    D.pair(4,10, byteArrayOf(40, 51, 62, 73))
//    D.calcu(6,30, byteArrayOf(81, 87, 47, 59, 81, 18))
    println(longestPalindrome("babad"))
    println(longestPalindrome("cbbd"))
    println(longestPalindrome("bb"))
    println(longestPalindrome("bbb"))
    println(longestPalindrome("bbbb"))
}

/**
 * 从中间向两边扩展最终优化，根据前面回文串计算的结果跳过后面可以跳过的计算
 */
fun longestPalindrome(s: String): String {
    var length = 1
    var index = 0
    fun expand(start: Int, end: Int): Int {
        var i = start
        var j = end
        while (--i in s.indices && ++j in s.indices && s[i] == s[j]);
        return if (i !in s.indices) j - i else j - i - 1
    }

    val sb = StringBuffer()
    for (c in s) {
        sb.append('*')
        sb.append(c)
    }
    sb.append('*')

    for (i in 0 until sb.lastIndex) {
        if (i > index) {
        }
        var a = expand(i, i)
        if (s[i] == s[i + 1]) {
            val b = expand(i, i + 1)
            if (b > a) {
                a = b
            }
        }
        if (a > length) {
            length = a
            index = i
        }
    }

    val list = LinkedList<Char>()
    list.add(s[index])
    var a = index - 1
    var b = index + 1
    if (length % 2 == 0) {
        list.add(s[index + 1])
        b++
    }
    while (a in s.indices && b in s.indices) {
        if (s[a] == s[b]) {
            list.add(s[a--])
            list.addFirst(s[b++])
        } else {
            break
        }
    }
    return list.joinToString(separator = "")
}

/**
 * 从中间向两边扩展优化
 */
fun longestPalindrome7(s: String): String {
    fun expand(start: Int, end: Int): Int {
        var i = start
        var j = end
        while (--i in s.indices && ++j in s.indices && s[i] == s[j]);
        return if (i !in s.indices) j - i else j - i - 1
    }

    var length = 1
    var index = 0
    for (i in 0 until s.lastIndex) {
        var a = expand(i, i)
        if (s[i] == s[i + 1]) {
            val b = expand(i, i + 1)
            if (b > a) {
                a = b
            }
        }
        if (a > length) {
            length = a
            index = i
        }
    }

    val list = LinkedList<Char>()
    list.add(s[index])
    var a = index - 1
    var b = index + 1
    if (length % 2 == 0) {
        list.add(s[index + 1])
        b++
    }
    while (a in s.indices && b in s.indices) {
        if (s[a] == s[b]) {
            list.add(s[a--])
            list.addFirst(s[b++])
        } else {
            break
        }
    }
    return list.joinToString(separator = "")
}

/**
 * 使用动态规划判断所有的字串是不是回文串
 */
fun longestPalindrome6(s: String): String {
    val p = Array(s.length) { BooleanArray(s.length) }
    var start = 0
    var end = 0
    for (i in p.indices) {
        p[i][i] = true
    }
    for (i in 1 until s.length) {
        for (j in 0 until i) {
            p[i][j] = s[i] == s[j] && (i - j == 1 || p[i - 1][j + 1])
            if (p[i][j] && end - start < i - j) {
                end = i
                start = j
            }
        }
    }
//    println("start=${start}, end=${end}")
    return s.substring(start..end)
}

/**
 * 找到所有子串，判断他是不是回文串，从是的中取出最长的
 */
fun longestPalindrome5(s: String): String {
    val array = s.toCharArray()
    var length = 0
    var longest = ""
    for (i in array.indices) {
        for (j in i until array.size) {
            if (isPalindrome(array, i, j)) {
                if (j - i + 1 > length) {
                    longest = s.substring(i..j)
                    length = j - i + 1
                }
            }
        }
    }
    return longest
}

fun isPalindrome(array: CharArray, start: Int, end: Int): Boolean {
    var s = start
    var e = end
    while (s < e) {
        if (array[s++] != array[e--]) {
            return false
        }
    }
    return true
}

/**
 * 找到所有子串，判断他是不是回文串，从是的中取出最长的
 */
fun longestPalindrome4(s: String): String {
    val array = s.toCharArray()
    var length = 0
    var longest = ""
    fun isPalindrome(start: Int, end: Int): Boolean {
        var s = start
        var e = end
        while (s < e) {
            if (array[s++] != array[e--]) {
                return false
            }
        }
        return true
    }
    for (i in array.indices) {
        for (j in i until array.size) {
            if (isPalindrome(i, j)) {
                if (j - i + 1 > length) {
                    longest = s.substring(i..j)
                    length = j - i + 1
                }
            }
        }
    }
    return longest
}

// 不能用
fun longestPalindrome3(s: String): String {
    var longest = ""
    var length = 0
    var maxAppend = 0
    var index = 0
    val array = s.toCharArray()
    var a = 0
    var b = 0
    var size = 0
    var append = 0

    fun append(c: Char): Boolean =
        if (array.getOrNull(b) == c && size == 1) {
            b++
            size++
            append = 1
            true
        } else if (array.getOrNull(a) == c && size == 1) {
            a--
            size++
            append = 2
            true
        } else {
            false
        }

    fun find(c: Char, i: Int, isAppend: Boolean) {
        while (a in array.indices || b in array.indices) {
            if (isAppend && append(c)) else if (array.getOrNull(a) == array.getOrNull(b)) {
                a--
                b++
                size += 2
            } else {
                break
            }
        }
        if (size > length) {
            length = size
            index = i
            maxAppend = append
            println("length: $length, maxAppend: $maxAppend, index: $index")
        }
    }

    for (i in array.indices) {
        val c = array[i]
        fun init() {
            size = 1
            append = 0
            a = i - 1
            b = i + 1
        }
        init()
        find(c, i, true)
        init()
        find(c, i, false)
    }

    a = index - 1
    b = index + 1
    val list = LinkedList<Char>()
    if (maxAppend == 1) {
        list.addFirst(array[index - 1])
        a--
    } else if (maxAppend == 2) {
        list.add(array[index + 1])
        b++
    }
    println("index: $index, maxAppend: $maxAppend")
    while (a in array.indices && b in array.indices) {
        if (array[a] == array[b]) {
            list.addFirst(array[a--])
            list.add(array[b++])
        } else {
            break
        }
    }
    longest = list.joinToString(separator = "")
    return longest
}

fun longestPalindrome2(s: String): String {
    var longest = ""
    val array = s.toCharArray()
    var a = 0
    var b = 0
    val list = LinkedList<Char>()

    fun append(c: Char): Boolean =
        if (array.getOrNull(b) == c && list.size == 1) {
            list.add(array[b++])
            true
        } else if (array.getOrNull(a) == c && list.size == 1) {
            list.add(array[a++])
            true
        } else {
            false
        }

    fun find(c: Char, isAppend: Boolean) {
        while (a in array.indices || b in array.indices) {
            if (isAppend && append(c)) else if (array.getOrNull(a) == array.getOrNull(b)) {
                list.add(array[b++])
                list.addFirst(array[a--])
            } else {
                break
            }
        }
        if (list.size > longest.length) {
            longest = list.joinToString(separator = "")
        }
    }

    for (i in array.indices) {
        val c = array[i]
        fun init() {
            list.clear()
            list.add(c)
            a = i - 1
            b = i + 1
        }
        init()
        find(c, true)
        init()
        find(c, false)
    }
    return longest
}

/**
 * 遍历每个字母为回文串的中间一个字母时,所组成的回文串的长度，取最长
 */
fun longestPalindrome1(s: String): String {
    var longest = ""
    val array = s.toCharArray()
    var a: Int
    var b: Int
    val list = LinkedList<Char>()
    for (i in array.indices) {
        list.clear()
        val c = array[i]
        list.add(c)
        a = i - 1
        b = i + 1
        while (a in array.indices || b in array.indices) {
            if (array.getOrNull(b) == c && list.size == 1) {
                list.add(array[b++])
            } else if (array.getOrNull(a) == c && list.size == 1) {
                list.add(array[a++])
            } else if (array.getOrNull(a) == array.getOrNull(b)) {
                list.add(array[b++])
                list.addFirst(array[a--])
            } else {
                break
            }
        }
        if (list.size > longest.length) {
            longest = list.joinToString(separator = "")
        }
        list.clear()
        list.add(c)
        a = i - 1
        b = i + 1
        while (a in array.indices || b in array.indices) {
            if (array.getOrNull(a) == array.getOrNull(b)) {
                list.add(array[b++])
                list.addFirst(array[a--])
            } else {
                break
            }
        }
        if (list.size > longest.length) {
            longest = list.joinToString(separator = "")
        }
    }
    return longest
}
