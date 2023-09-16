package com.example;

import java.util.*;

/**
 * 删除链表的倒数第 N 个结点
 * 提示
 * 中等
 * 2.5K
 * 相关企业
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class Y {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        new Y().removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.print(head.val+",");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode h = head;
        while (h != null) {
            count++;
            h = h.next;
        }
        int m = count - n;
        if (m == 0) {
            return head.next;
        }
        ListNode l = head;
        h = head.next;
        System.out.println("m=" + m + "c=" + count);
        while (--m > 0) {
            l = h;
            h = h.next;
        }
        l.next = h == null ? null : h.next;
        return head;
    }

    public static class ListNode {
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
}
