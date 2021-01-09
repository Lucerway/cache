package com.lucer.leetcode;

/**
 * 题目描述：一个链表，奇数位升序偶数位降序，让链表变成升序的。
 * <p>
 * 比如：1 8 3 6 5 4 7 2 9，最后输出1 2 3 4 5 6 7 8 9。
 * <p>
 * 分析：
 * <p>
 * 这道题可以分成三步：
 * <p>
 * 首先根据奇数位和偶数位拆分成两个链表。
 * <p>
 * 然后对偶数链表进行反转。
 * <p>
 * 最后将两个有序链表进行合并。
 *
 * @author: liuchuan
 */
public class OddIncreaseEvenDecrease {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 拆分2个链表
     */
    public ListNode[] getList(ListNode head) {

        ListNode head1 = null;
        ListNode head2 = null;

        ListNode curr1 = null;
        ListNode curr2 = null;

        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                if (curr1 != null) {
                    curr1.next = head;
                    curr1 = curr1.next;
                } else {
                    curr1 = head;
                    head1 = curr1;
                }
            } else {
                if (curr2 != null) {
                    curr2.next = head;
                    curr2 = curr2.next;
                } else {
                    curr2 = head;
                    head2 = curr2;
                }
            }
            count++;
            head = head.next;
        }
        curr1.next = null;
        curr2.next = null;
        return new ListNode[]{head1, head2};
    }

    public ListNode reserve(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return head.next;
    }


    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }

    public ListNode solution(ListNode head) {
        ListNode[] nodes = getList(head);
        nodes[1] = reserve(nodes[1]);
        return mergeTwoList(nodes[0], nodes[1]);
    }
}
