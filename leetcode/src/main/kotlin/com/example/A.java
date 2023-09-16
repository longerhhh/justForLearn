package com.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A {
    public static void main(String[] args) {
//        var a = permute(new int[]{1, 2, 3});
//        for (List<Integer> b : a) {
//            System.out.println(b);
//        }
        permutation(new int[]{1, 2, 3});
    }

    public static void permutation(int[] nums) {
        visit(nums, 0, nums.length);
    }

    static int t = 0;

    private static void visit(int[] nums, int start, int end) {
        if (end - start == 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = start; i < end; i++) {
            swap(nums, start, i);
            visit(nums, start + 1, end);
            swap(nums, start, i);
        }
    }

    private static void swap(int[] a, int x, int y) {
        if (x != y) {
            t = a[x];
            a[x] = a[y];
            a[y] = t;
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        visit(list, new LinkedList<>(), nums);
        return list;
    }

    static void visit(List<List<Integer>> result, LinkedList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            visit(result, list, nums);
            list.removeLast();
        }
    }
}
