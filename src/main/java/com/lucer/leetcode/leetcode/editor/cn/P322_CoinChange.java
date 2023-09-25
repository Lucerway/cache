package com.lucer.leetcode.leetcode.editor.cn;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2552 👎 0


/*
 * 题目Id：322
 * 题目：零钱兑换
 * 日期：2023-09-04 14:03:53
 * @author liuchuan
 */
public class P322_CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322_CoinChange().new Solution();

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int tempAmount = amount;

            bubbleSort(coins);
            for (int i = 0; i < coins.length; i++) {
                tempAmount = tempAmount % coins[i];
                if (tempAmount == 0) {

                }


            }


            return -1;
        }


        public int[] bubbleSort(int[] nums) {
            if (nums.length == 0) {
                return nums;
            }

            // 外层循环控制比较轮数
            for (int i = 0; i < nums.length - 1; i++) {
                // 内层循环进行相邻元素比较和交换
                for (int j = 0; j < nums.length - i - 1; j++) {
                    if (nums[j] < nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }

            return nums;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    public class Solution2 {
        public int coinChange(int[] coins, int amount) {
            if (amount < 1) {
                return 0;
            }
            return coinChange(coins, amount, new int[amount]);
        }

        private int coinChange(int[] coins, int rem, int[] count) {
            if (rem < 0) {
                return -1;
            }
            if (rem == 0) {
                return 0;
            }
            if (count[rem - 1] != 0) {
                return count[rem - 1];
            }
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);
                if (res >= 0 && res < min) {
                    min = 1 + res;
                }
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];
        }
    }


}
