package com.lucer.historyleet;

/**
 *
 * @author: liuchuan
 */
public class LDR {

    // 节点构造
    public class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }


    public static void ldrRe(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        ldrRe(treeNode.left);
        ldrRe(treeNode.right);
    }


}
