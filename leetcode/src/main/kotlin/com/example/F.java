package com.example;

import java.util.LinkedList;

public class F {
    public static void main(String[] args) {
        System.out.println(new F().isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeft(c)) {
                list.add(c);
            } else if (isRight(c)) {
                Character d = list.pollLast();
                if (d == null || !isMatch(d, c)) {
                    return false;
                }
            }
        }
        return list.isEmpty();
    }

    private boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isRight(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean isMatch(char c, char d) {
        return c == '(' && d == ')' || c == '[' && d == ']' || c == '{' && d == '}';
    }
}
