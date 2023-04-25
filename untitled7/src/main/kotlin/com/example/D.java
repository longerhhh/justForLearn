package com.example;

import java.util.ArrayList;
import java.util.List;

public class D {
    public static void main(String[] args) {
        System.out.println(new D().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        String[] s = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[][] map = new char[s.length][];
        for (int i = 0; i < map.length; i++) {
            map[i] = s[i].toCharArray();
        }
        List<String> result = new ArrayList<>();
        char[] chars = digits.toCharArray();
        int[] ds = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ds[i] = chars[i] - '0';
        }
        visit(ds, new int[digits.length()], new StringBuffer(digits.length()), result, map, 0);
        return result;
    }

    void visit(int[] digits, int[] position, StringBuffer sb, List<String> result, char[][] map, int index) {
        if (index < digits.length) {
            char[] chars = map[digits[index]];
            int pos = 0;
            while (pos < chars.length) {
                position[index] = pos;
                sb.append(chars[pos]);
                visit(digits, position, sb, result, map, index + 1);
                sb.deleteCharAt(index);
                pos++;
            }
        } else {
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
        }
    }
}
