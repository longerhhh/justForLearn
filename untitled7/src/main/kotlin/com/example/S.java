package com.example;

import java.util.LinkedHashMap;

/**
 * 整数转罗马数字
 * 中等
 * 1.1K
 * 相关企业
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 3999
 */
public class S {
    public static void main(String[] args) {
        System.out.println(new S().intToRoman(20));
    }

    public String intToRoman(int num) {
        var kv = new LinkedHashMap<Integer, String>();
        kv.put(1000, "M");
        kv.put(900, "CM");
        kv.put(500, "D");
        kv.put(400, "CD");
        kv.put(100, "C");
        kv.put(90, "XC");
        kv.put(50, "L");
        kv.put(40, "XL");
        kv.put(10, "X");
        kv.put(9, "IX");
        kv.put(5, "V");
        kv.put(4, "IV");
        kv.put(1, "I");
        var sb = new StringBuilder();
        var it = kv.entrySet().iterator();
        while (num > 0) {
            if (it.hasNext()) {
                var e = it.next();
                var k = e.getKey();
                var v = e.getValue();
                if (num >= k) {
                    num -= k;
                    sb.append(v);
                }
            }
        }
        return sb.toString();
    }

    public String intToRoman1(int num) {
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            if (num >= 1000) {
                num -= 1000;
                sb.append('M');
            } else if (num >= 900) {
                num -= 900;
                sb.append("CM");
            } else if (num >= 500) {
                num -= 500;
                sb.append("D");
            } else if (num >= 400) {
                num -= 400;
                sb.append("CD");
            } else if (num >= 100) {
                num -= 100;
                sb.append('C');
            } else if (num >= 90) {
                num -= 90;
                sb.append("XC");
            } else if (num >= 50) {
                num -= 50;
                sb.append("L");
            } else if (num >= 40) {
                num -= 40;
                sb.append("XL");
            } else if (num >= 10) {
                num -= 10;
                sb.append("X");
            } else if (num == 9) {
                num -= 9;
                sb.append("IX");
            } else if (num >= 5) {
                num -= 5;
                sb.append("V");
            } else if (num == 4) {
                num -= 4;
                sb.append("IV");
            } else {
                num -= 1;
                sb.append("I");
            }
        }
        return sb.toString();
    }
}
