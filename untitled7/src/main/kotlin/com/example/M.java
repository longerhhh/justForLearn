package com.example;

import java.util.LinkedList;
import java.util.List;

public class M {
    public static void main(String[] args) {
        System.out.println(new M().convert("PAYPALISHIRING", 4).equals(new M().convert1("PAYPALISHIRING", 4)));
        System.out.println(new M().convert("PAYPALISHIRING", 3).equals(new M().convert1("PAYPALISHIRING", 3)));
        System.out.println(new M().convert("PAYPALISHIRING", 2).equals(new M().convert1("PAYPALISHIRING", 2)));
        System.out.println((new M().convert("PAYPALISHIRING", 1).equals(new M().convert1("PAYPALISHIRING", 1))));
        System.out.println(new M().convert("A", 1).equals(new M().convert1("A", 1)));
    }

    /**
     * 找规律
     * 3：
     * 1   5   9     13
     * 2 4 6 8 10 12 14
     * 3   7   11    15
     * <p>
     * 间隔 4 2 4
     * <p>
     * 2：
     * 1 3 5 7 9  11
     * 2 4 6 8 10 12
     * <p>
     * 1：
     * 1 2 3 4 5 6 7 8 9
     * <p>
     * 4：
     * 1     7        13
     * 2   6 8     12 14
     * 3 5   9  11    15
     * 4     10       16
     * <p>
     * 间隔 6 4,2 6
     * <p>
     * 5：
     * 1     9         17
     * 2   8 10     16 18
     * 3  7  11   15   19
     * 4 6   12 14     20
     * 5     13        21
     * <p>
     * 间隔 8 6,2 4，4 2,6 8
     */
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows>=s.length()) {
            return s;
        }
        char[] chars = s.toCharArray();
        // 生成间隔数组
        int[][] distance = new int[numRows][2];
        var d = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++) {
            distance[i][0] = d - 2 * i;
            distance[i][1] = d - 2 * (numRows - 1 - i);
        }
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < numRows; col++) {
            for (int i = col, j = 0; i < chars.length; j++) {
                sb.append(chars[i]);
                i += col == 0 ? distance[col][0] : col == numRows - 1 ? distance[col][1] : distance[col][j % 2];
            }
        }
        return sb.toString();
    }

    /**
     * 用二维数组存储数据，遍历找出最终结果
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert1(String s, int numRows) {
        char[] chars = s.toCharArray();
        List<Character>[] result = new List[numRows];
        for (int i = 0; i < result.length; i++) {
            result[i] = new LinkedList<>();
        }
        boolean isSparse = false;
        for (int i = 0, j = 0; i < chars.length; i++) {
            // xx
            if (j == numRows && numRows > 2) {
//                System.out.println("numRows, i="+i+",j="+j+",isSparse="+isSparse);
                j -= 2;
                add(result, j--, chars[i]);
                isSparse = true;
            } else if (isSparse && j > 0) {
//                System.out.println("isSparse, i="+i+",j="+j+",isSparse="+isSparse);
                if (j == 1) {
                    isSparse = false;
                }
                add(result, j--, chars[i]);
            } else {
//                System.out.println("else, i="+i+",j="+j+",isSparse="+isSparse);
                if (isSparse) {
                    isSparse = false;
                }
                if (j == numRows) {
                    j -= numRows;
                }
                result[j].add(chars[i]);
                j++;
            }
        }
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
//        System.out.println("--------------------------------");
        StringBuffer sb = new StringBuffer();
        for (List<Character> characters : result) {
            for (char c : characters) {
                if (c != ' ') {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    void add(List<Character>[] list, int r, char c) {
        for (int i = 0; i < list.length; i++) {
            list[i].add(r == i ? c : ' ');
        }
    }
}
