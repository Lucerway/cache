package com.leetcode.lucer.string;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/solution/shan-chu-pai-xu-lian-biao-zhong-de-zhong-fu-yuan-s/
 * 删除排序链表中的重复元素
 * <p>
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * @author: liuchuan
 */
public class NodeListDeleteDuplicates {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    /**
     * 题目：给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 思路：删除所有头部的重复节点，返回不重复的第一个节点。
     * <p>
     * 1.特殊情况，头节点为null或头节点下一节点为null，直接返回头节点，这时不存在重复节点
     * 2.如果头节点与头节点的下一节点值相等，跳过所有相等节点。递归调用函数判断最后一个跳过节点的后一节点。
     * 3.如果头节点与头节点的下一节点值不等，递归调用函数判断头节点的后一节点。
     *
     * @param head
     * @return
     */
    public static ListNode deleteDumplicatesV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDumplicatesV2(head.next);
        } else {
            head.next = deleteDumplicatesV2(head.next);
            return head;
        }
    }


}
