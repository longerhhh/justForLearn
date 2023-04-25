package com.example;

import java.util.LinkedList;

public class G {
    public static void main(String[] args) {
    }

    public int longestValidParentheses(String s) {
        int max = 0, count = 0;
        LinkedList<Boolean> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(i);
                if (c == '(') {
                    list.push(true);
                    count++;
                } else if (c == ')') {
                    list.pop();
                    count++;
                }
            }
            if (list.isEmpty()) {
            }
        }
        return 0;
    }
}
