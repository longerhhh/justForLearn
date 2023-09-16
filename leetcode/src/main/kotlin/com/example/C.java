package com.example;

import java.util.Arrays;

public class C {
    void permutation(int[] nums) {
        int t = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                t = i - 1;
                break;
            }
        }
        if (t != -1) {
            for (int i = nums.length - 1; i >= 1; i--) {
                if (nums[i] > nums[t]) {
                    swap(nums, t, i);
                    break;
                }
            }
        }
        for (int i = 1; i <= (nums.length-t-1)/2; i++) {
            swap(nums,t+i, nums.length-i);
        }
        System.out.println(Arrays.toString(nums));
    }

    void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

    public static void main(String[] args) {
        new C().permutation(new int[]{3,2,1});
    }
}
