package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * 中等
 * 1.6K
 * 相关企业
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * -1E9 <= nums[i] <= 1E9
 * -1E9 <= target <= 1E9
 */
public class X {
    public static void main(String[] args) {
        System.out.println(new X().fourSum(new int[]{0}, 0));
        System.out.println(new X().fourSum(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000));
    }

    /**
     * 比fourSum1多了剪枝操作
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int a0 = nums[0], a1 = nums[0], a;
        // 排除一定大于的情况以及一定小于的情况
        // 如果最小的四个数和大于目标值或者最大的四个数和小于目标值，则不存在和为目标值的情况，不进入循环
        if (nums.length > 3) {
            for (int i = 0; i < nums.length - 3; i++) {
                // 跳过重复数值
                if (i > 0 && a0 == nums[i]) {
                    System.out.println("repeat");
                    continue;
                }
                // 如果最小的四个数和大于目标值则不存在和为目标值的情况，进入下一个循环
                // 因为相加可能超过int边界，所以转成long
                if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    System.out.println("jump");
                    continue;
                }
                a0 = nums[i];
                for (int j = i + 1; j < nums.length - 2; j++) {
                    // 跳过重复数值
                    if (j > i + 1 && nums[j] == a1) {
                        continue;
                    }
                    a1 = nums[j];
                    a = a0 + a1;
                    // 排除一定大于的情况以及一定小于的情况
                    // 如果最小的四个数和大于目标值则不存在和为目标值的情况，进入下一个循环
                    // 因为相加可能超过int边界，所以转成long
                    if ((long) a + nums[j + 1] + nums[j + 2] > target) {
                        continue;
                    }
                    int s = j + 1, e = nums.length - 1;
                    // 当s和e相等退出循环
                    while (s < e) {
                        int start = nums[s];
                        int end = nums[e];
                        int sum = target - start - end;
                        System.out.println("s=" + s + ",e=" + e + ",sum=" + sum + ",start=" + start + ",end=" + end + ", i=" + i);
                        // 和为-a，添加到列表，移动左指针
                        if (sum == a) {
                            // 校验结果，排除越界情况
                            if ((long) a + start + end == (long) (a + start + end)) {
                                List<Integer> l = new ArrayList<>(4);
                                l.add(a0);
                                l.add(a1);
                                l.add(start);
                                l.add(end);
                                result.add(l);
                            }
                            while (++s < e && nums[s] == start) ;
                            // 和大于-a，移动右指针
                        } else if (sum < a) {
                            // 使用循环跳过重复数值
                            while (--e > s && nums[e] == end) ;
                            // 和小于-a，移动左指针
                        } else {
                            // 使用循环跳过重复数值
                            while (++s < e && nums[s] == start) ;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * 利用嵌套循环确定两个数，剩余两个使用双指针方法计算
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int a0 = nums[0], a1 = nums[0], a;
        for (int i = 0; i < nums.length - 3; i++) {
            // 跳过重复数值
            if (i > 0 && a0 == nums[i]) {
                continue;
            }
            // 排除一定大于的情况以及一定小于的情况
            a0 = nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 跳过重复数值
                if (j > i + 1 && nums[j] == a1) {
                    continue;
                }
                a1 = nums[j];
                a = a0 + a1;
                // 排除一定大于的情况以及一定小于的情况
                int s = j + 1, e = nums.length - 1;
                // 当s和e相等退出循环
                while (s < e) {
                    int start = nums[s];
                    int end = nums[e];
                    int sum = target - start - end;
                    System.out.println("s=" + s + ",e=" + e + ",sum=" + sum + ",start=" + start + ",end=" + end + ", i=" + i);
                    // 和为-a，添加到列表，移动左指针
                    if (sum == a) {
                        // 校验结果，排除越界情况
                        if ((long) a + start + end == (long) (a + start + end)) {
                            List<Integer> l = new ArrayList<>(4);
                            l.add(a0);
                            l.add(a1);
                            l.add(start);
                            l.add(end);
                            result.add(l);
                        }
                        while (++s < e && nums[s] == start) ;
                        // 和大于-a，移动右指针
                    } else if (sum < a) {
                        // 使用循环跳过重复数值
                        while (--e > s && nums[e] == end) ;
                        // 和小于-a，移动左指针
                    } else {
                        // 使用循环跳过重复数值
                        while (++s < e && nums[s] == start) ;
                    }
                }
            }
        }
        return result;
    }
}
