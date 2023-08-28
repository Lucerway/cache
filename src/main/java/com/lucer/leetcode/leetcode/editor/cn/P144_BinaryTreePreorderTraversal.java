package com.lucer.leetcode.leetcode.editor.cn;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
// 
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
// 
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1119 👎 0


import java.util.ArrayList;
import java.util.List;

/*
 * 题目Id：144
 * 题目：二叉树的前序遍历
 * 日期：2023-08-28 15:20:36
 * @author liuchuan
 */
public class P144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {


    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    class Solution {

        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            preorder(root, result);

            return result;
        }


        /**
         * 先序遍历
         */
        public void preorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }

            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    /**
     * 中序遍历
     */
    public void middleOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }


        middleOrder(root.left, list);
        list.add(root.val);
        middleOrder(root.right, list);
    }


    /**
     * 后序遍历
     */
    public void afterOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        afterOrder(root.left, list);
        afterOrder(root.right, list);
        list.add(root.val);

    }

}
