package com.leetcode.lucer.string;


/**
 * 判断链表是否有环
 */
public class LoopLink {

    public class NodeList {
        int value;
        NodeList next;

        public NodeList(int value) {
            this.value = value;
        }
    }


    public static boolean hasCircle(NodeList head) {
        if (head == null || head.next == null) {
            return false;
        }
        NodeList slow = head;
        NodeList fast = head.next;
        while (slow != fast) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }


}
