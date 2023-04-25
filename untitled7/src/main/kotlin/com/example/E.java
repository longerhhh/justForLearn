package com.example;

import java.util.LinkedList;
import java.util.List;

public class E {
    public static void main(String[] args) {
        System.out.println(new E().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        visit(result, new StringBuilder(n*2), n, 0, new int[2]);
        return result;
    }

    void visit(List<String> result,  StringBuilder sb,  int n, int i, int[] count) {
        if (i == n * 2) {
            result.add(sb.toString());
            return;
        }
        if (count[0] > count[1] && count[0] < n) {
            visit(result, sb, n, i, count, true);
            visit(result, sb, n, i, count, false);
        } else visit(result, sb, n, i, count, count[0] != n);
    }

    void visit(List<String> result, StringBuilder sb, int n, int i, int[] count, boolean type) {
        int index = type ? 0 : 1;
        sb.append(type?'(':')');
        count[index]++;
        visit(result, sb, n, i + 1, count);
        count[index]--;
        sb.deleteCharAt(sb.length()-1);
    }
}
