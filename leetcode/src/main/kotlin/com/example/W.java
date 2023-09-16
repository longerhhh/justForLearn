package com.example;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 中等
 * 1.4K
 * 相关企业
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 */
public class W {
    public static void main(String[] args) {
        System.out.println(new W().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(new W().threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int a = nums[0];
        int d = Integer.MAX_VALUE, r = 0;
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复数值
            if (i > 0 && a == nums[i]) {
                continue;
            }
            a = nums[i];
            int s = i + 1, e = nums.length - 1;
            // 当s和e相等退出循环
            while (s < e) {
                int start = nums[s];
                int end = nums[e];
                int sum = target - start - end;
                System.out.println("s=" + s + ",e=" + e + ",sum=" + sum + ",start=" + start + ",end=" + end + " a=" + a + ", i=" + i);
                // 和为-a，添加到列表，移动左指针
                if (sum == a) {
                    return target;
//                    while (++s < e && nums[s] == start) ;
                    // 和大于-a，移动右指针
                } else {
                    if (sum < a) {
                        // 使用循环跳过重复数值
                        while (--e > s && nums[e] == end) ;
                        // 和小于-a，移动左指针
                    } else {
                        // 使用循环跳过重复数值
                        while (++s < e && nums[s] == start) ;
                    }
                    sum = Math.abs(sum - a);
                    if (sum < d) {
                        d = sum;
                        r = a + start + end;
                    }
                    System.out.println("r=" + r + " d=" + d);
                }
            }
        }
        return r;
    }
}
