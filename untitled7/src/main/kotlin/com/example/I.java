package com.example;

import java.util.HashMap;
import java.util.LinkedList;

public class I {
    public static void main(String[] args) {
        new I().twoSum2(new int[]{2, 7, 11, 15}, 9);
    }


    public int[] twoSum2(int[] nums, int target) {
//        Hashtable<Integer, Integer> kv = new Hashtable<Integer, Integer>();
        HashMap<Integer, Integer> kv = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (kv.containsKey(a)) {
                return new int[]{i, kv.get(a)};
            } else {
                kv.put(nums[i], i);
            }
        }
        return new int[2];
    }
}

/**
 * Definition for singly-linked list.
 * <code>
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * </code>
 */
class Solution {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode r = result;
        int a = 0, b = 0, t = 0, x = 0, y = 0;
        do {
            a = l1.val;
            b = l2.val;
            t = a + b + y;
            if (t >= 10) {
                x = t - 10;
                y = 1;
            } else {
                x = t;
                y = 0;
            }
            r.val = x;
            r.next = new ListNode();
            r = r.next;
            l1 = l1.next;
            l2 = l2.next;
        } while (l1 != null && l2 != null);
        if (l2 == null) {
            l2 = l1;
        }
        if (l2 != null) {
            do {
                t = l2.val + y;
                if (t >= 10) {
                    x = t - 10;
                    y = 1;
                } else {
                    x = t;
                    y = 0;
                }
                r.val = x;
                r.next = new ListNode();
                r = r.next;
                l2 = l2.next;
            } while (l2.next != null);
        }
        if (y != 0) {
            r.next = new ListNode(y);
        }
        r = result;
        while (r != null) {
            if (r.next.next == null) {
                r.next = null;
            }
            r = r.next;
        }
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode r = result;
        int a = 0, b = 0, t = 0, x = 0, y = 0;
        do {
            a = l1 != null ? l1.val : 0;
            b = l2 != null ? l2.val : 0;
            t = a + b + y;
            if (t >= 10) {
                x = t - 10;
                y = 1;
            } else {
                x = t;
                y = 0;
            }
            r.val = x;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 != null || l2 != null) {
                r.next = new ListNode();
                r = r.next;
            } else {
                break;
            }
        } while (true);
        if (y != 0) {
            r.next = new ListNode(y);
        }
        return result;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        return max(cs, 0, cs.length);
    }

    int max(char[] cs, int start, int end) {
        if (end - start <= 1) {
            return 1;
        }
        int m = (start+end)/2;
        int s = max(cs, start,m);
        int e = max(cs, m, end);
        LinkedList<Character> list = new LinkedList<>();
        list.add(cs[m]);
        for (int i = m; i < end; i++) {
            if (!list.contains(cs[i])) {
                list.add(cs[i]);
            }
        }
        for (int i = m; i >= 0; i--) {
            if (!list.contains(cs[i])) {
                list.addFirst(cs[i]);
            }
        }
        int m1 = list.size();
        System.out.println("mid1="+list);
        list.clear();
        list.add(cs[m]);
        for (int i = m; i >= 0; i--) {
            if (!list.contains(cs[i])) {
                list.addFirst(cs[i]);
            }
        }
        for (int i = m; i < end; i++) {
            if (!list.contains(cs[i])) {
                list.add(cs[i]);
            }
        }
        System.out.println("mid2="+list);
        m1 = Math.max(list.size(), m1);
        m1 = Math.max(s, m1);
        m1 = Math.max(e, m1);
        return m1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
