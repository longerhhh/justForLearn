package com.example;

/**
 * 正则表达式匹配
 * 困难
 * 3.6K
 * 相关企业
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * <p>
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class Q {
    public static void main(String[] args) {
    }

    private static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        } else if (s.charAt(i - 1) == p.charAt(j)) {
            return true;
        } else {
            return p.charAt(j) == '.';
        }
    }

    /**
     * 动态规划匹配
     * 两种情况
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sn1 = s.length() + 1, pn1 = p.length() + 1;
        boolean[][] m = new boolean[sn1][pn1];
        m[0][0] = true;
        for (int i = 0; i < sn1; i++) {
            for (int j = 1; j < pn1; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (matches(s, p, i, j - 2)) {
                        m[i][j] = m[i - 1][j] || m[i][j - 2];
                    } else {
                        m[i][j] = m[i][j - 2];
                    }
                } else {
                    if (matches(s, p, i, j - 1)) {
                        m[i][j] = m[i - 1][j - 1];
                    } else {
                        m[i][j] = false;
                    }
                }
            }
        }
        return m[sn1 - 1][pn1 - 1];
    }
}
