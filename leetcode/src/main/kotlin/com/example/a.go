package main

import "fmt"

func main() {
    fmt.Println("Hello, World!")
}

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    var n1 = len(nums1)
    var n2 = len(nums2)
    var n = n1 + n2
    var isEven = n%2 == 0
    var x = n / 2
    var i = 0
    var j = 0
    var k = 0
    var last = 0
    var current = 0
    for i < n1 || j < n2 {
        last = current
        if i >= n1 {
            current = nums2[j]
            j++
        } else if j >= n2 {
            current = nums1[i]
            i++
        } else if nums1[i] > nums2[j] {
            current = nums2[j]
            j++
        } else {
            current = nums1[i]
            i++
        }
        if k == x {
            if isEven {
                return float64(last+current) / float64(2)
            } else {
                return float64(current)
            }
        }
        k++
    }
    return 0
}
