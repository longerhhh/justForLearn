package com.example

import java.util.*


fun threeSum(nums: IntArray): List<List<Int>>? {
    val result: MutableList<List<Int>> = ArrayList()
    val t = LinkedList<Int>()
    for (i in nums.indices) {
        t.add(nums[i])
        for (j in i + 1 until nums.size) {
            if (j != i + 1) {
                t.removeLast()
            }
            t.add(nums[j])
            for (k in j + 1 until nums.size) {
                if (k != j + 1) {
                    t.removeLast()
                }
                t.add(nums[k])
                if (t.sum() == 0 && !result.contains(t)) {
                    result.add(t.clone() as List<Int>)
                }
            }
            t.removeLast()
        }
        t.removeLast()
    }
    return result
}

private fun sum(l: List<Int>): Int {
    val it = l.iterator()
    var sum = 0
    while (it.hasNext()) {
        sum += it.next()
    }
    return sum
}
