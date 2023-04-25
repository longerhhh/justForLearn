import java.util.LinkedList

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    printAll(intArrayOf(1,2,3))
}

fun printAll(a: IntArray) {
    val result = mutableListOf<List<Int>>()
    visit(result, LinkedList(), a)
    println(result)
}

fun visit(result: MutableList<List<Int>>, list: LinkedList<Int>, a: IntArray) {
    if (list.size == a.size) {
        result.add(LinkedList(list))
        return
    }
    for (i in a.indices) {
        if (list.contains(a[i])) {
            continue
        }
        list.add(a[i])
        visit(result, list, a)
        list.removeLast()
    }
}
