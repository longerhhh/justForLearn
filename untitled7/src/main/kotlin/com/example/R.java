package com.example;

/**
 * 盛最多水的容器
 * 提示
 * 中等
 * 4.3K
 * 相关企业
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class R {
    /**
     * 双指针方法
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0, t = 0;
        for (int i = 0, j = height.length - 1; i < height.length && j > 0 && i < j; ) {
            if (height[i] < height[j]) {
                t = height[i] * (j - i);
                i++;
            } else {
                t = height[j] * (j - i);
                j--;
            }
            if (t > max) {
                max = t;
            }
        }
        return max;
    }

    /**
     * 超出时间限制
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int max = 0, t = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                t = (j - i) * (Math.min(height[i], height[j]));
                if (t > max) {
                    max = t;
                }
            }
        }
        return max;
    }
}
