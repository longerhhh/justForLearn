package com.example;

import java.util.LinkedList;

public class J {
    public static void main(String[] args) {
//endto mfgdw dwfcg pxiqv kuytd lcgd
        System.out.println(new J().lengthOfLongestSubstring("endtomfgdwdwfcgpxiqvkuytdlcgd"));
//        System.out.println(new J().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        return max(cs, 0, cs.length);
    }

    int max(char[] cs, int start, int end) {
        if (end - start == 1) {
            return 1;
        } else if (end - start == 0) {
            return 0;
        }
        int m = (start + end) / 2;
        int s = max(cs, start, m);
        int e = max(cs, m, end);
        LinkedList<Character> list = new LinkedList<>();
        list.add(cs[m]);
        for (int i = m + 1; i < end; i++) {
            if (!list.contains(cs[i])) {
                list.add(cs[i]);
            } else {
                break;
            }
        }
        for (int i = m - 1; i >= start; i--) {
            if (!list.contains(cs[i])) {
                list.addFirst(cs[i]);
            } else {
                break;
            }
        }
        int m1 = list.size();
        System.out.println("mid1=" + list);
        list.clear();
        list.add(cs[m]);
        for (int i = m - 1; i >= start; i--) {
            if (!list.contains(cs[i])) {
                list.addFirst(cs[i]);
            } else {
                break;
            }
        }
        for (int i = m + 1; i < end; i++) {
            if (!list.contains(cs[i])) {
                list.add(cs[i]);
            } else {
                break;
            }
        }
        System.out.println("mid2=" + list);
        m1 = Math.max(list.size(), m1);
        m1 = Math.max(s, m1);
        m1 = Math.max(e, m1);
        System.out.println(start + "," + end + "," + s + "," + e + "," + m1);
        return m1;
    }
}
