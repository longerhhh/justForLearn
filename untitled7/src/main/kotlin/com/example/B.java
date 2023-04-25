package com.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class B {
    List<List<Integer>> result = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        visit(new LinkedList<>(), new boolean[nums.length], nums);
        return result;
    }

    private void visit(LinkedList<Integer> list, boolean[] added, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (added[i]) {
                continue;
            }
            list.add(nums[i]);
            added[i] = true;
            visit(list, added, nums);
            added[i] = false;
            list.removeLast();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visit1(new LinkedList<>(), new boolean[nums.length], nums);
        return result;
    }

    private void visit1(LinkedList<Integer> list, boolean[] added, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (added[i] || i > 0 && nums[i] == nums[i - 1] && !added[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            added[i] = true;
            visit1(list, added, nums);
            added[i] = false;
            list.removeLast();
        }
    }

    public static void main(String[] args) {
//        System.out.println(new B().permute(new int[]{1, 2, 3}));
        System.out.println(new B().permuteUnique(new int[]{1, 1, 1, 2}));
    }
}
