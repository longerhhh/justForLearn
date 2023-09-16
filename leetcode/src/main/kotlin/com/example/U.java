package com.example;

/**
 * 最长公共前缀
 * 简单
 * 2.8K
 * 相关企业
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class U {
    public static void main(String[] args) {
        System.out.println(new U().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuffer sb = new StringBuffer();
        int minLength = strs[0].length();
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            boolean isAdd = true;
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    isAdd = false;
                    break;
                }
            }
            if (isAdd) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
