package com.example;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 *
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 */
public class H {
    public static void main(String[] args) {
//        String[] queries = new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
//        String pattern = "FB";
//        System.out.println(new H().camelMatch(queries, pattern));
        String[] queries = new String[]{"aksvbjLiknuTzqon","ksvjLimflkpnTzqn","mmkasvjLiknTxzqn","ksvjLiurknTzzqbn","ksvsjLctikgnTzqn","knzsvzjLiknTszqn"};
        String pattern = "ksvjLiknTzqn";
        System.out.println(new H().camelMatch1(queries, pattern));
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new LinkedList<>();
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int j = 0;
            boolean isMatch = true;
            for (int k = 0; k < query.length(); k++) {
                if (j < pattern.length() && query.charAt(k) == pattern.charAt(j)) {
                    j ++;
                    // 大写字母不匹配
                } else if (query.charAt(k) >= 'A' && query.charAt(k) <= 'Z') {
                    isMatch = false;
                    break;
                }
            }
            result.add(isMatch && j == pattern.length());
        }
        return result;
    }

    public List<Boolean> camelMatch1(String[] queries, String pattern) {
        StringBuilder sb = new StringBuilder();
        sb.append("[a-z]*");
        for (int i = 0; i < pattern.length(); i++) {
            sb.append(pattern.charAt(i));
            sb.append("[a-z]*");
        }
        List<Boolean> result = new LinkedList<>();
        String p = sb.toString();
        for (int i = 0; i < queries.length; i++) {
            result.add(Pattern.matches(p, queries[i]));
        }
        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    public int[] twoSum1(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}
