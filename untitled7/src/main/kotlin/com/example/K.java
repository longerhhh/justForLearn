package com.example;

import java.util.HashSet;
import java.util.LinkedList;

public class K {
    public static void main(String[] args) {
//endto mfgdw dwfcg pxiqv kuytd lcgd
        System.out.println(new K().lengthOfLongestSubstring("endtomfgdwdwfcgpxiqvkuytdlcgd"));
//        System.out.println(new J().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring1(String s) {
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<Character> l = new LinkedList<>(list);
        for (int i = 0; i < s.length(); i++) {
            l = new LinkedList<>(l);
            if (i > 0) {
                l.removeFirst();
            }
            int j = i + l.size();
            for (; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!l.contains(c)) {
                    l.add(c);
                } else {
                    break;
                }
            }
            if (l.size() > list.size()) {
                list = l;
            }
            System.out.println(i + ":" + l);
            if (j == s.length()) {
                break;
            }
        }
        return list.size();
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> l = new HashSet<>();
        int result = 0;
        for (int i = 0, j = 0; i < s.length() && j < s.length(); i++) {
            if (i > 0) {
                l.remove(s.charAt(i - 1));
            }
            j = i + l.size();
            while (j < s.length() && l.add(s.charAt(j++)));
            result = Math.max(result, l.size());
        }
        return result;
    }
}
