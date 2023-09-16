package com.example;

public class L {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, n = n1 + n2, m = n / 2, i = 0, j = 0, k = 0, last = 0, current = 0;
        boolean isEven = n % 2 == 0;
        while (i < n1 || j < n2) {
            last=current;
            if (i >= n1) {
                current = nums2[j++];
            } else if (j >= n2) {
                current = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                current = nums1[i++];
            } else {
                current=nums2[j++];
            }
            if (k++ == m) {
                return isEven?(last+current)/2.0 : current;
            }
        }
        return 0;
    }
}
