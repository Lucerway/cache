package com.lucer.leetcode.leetcode.editor.cn;

//给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。 
//
// 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。 
//
// 返回 你能获得的 最大 利润 。 
//
// 
//
// 示例 1： 
//
// 
//输入：prices = [7,1,5,3,6,4]
//输出：7
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
//     总利润为 4 + 3 = 7 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//     总利润为 4 。 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10⁴ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2225 👎 0


/*
 * 题目Id：122
 * 题目：买卖股票的最佳时机 II
 * 日期：2023-08-29 14:22:15
 * @author liuchuan
 */
public class P122_BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new P122_BestTimeToBuyAndSellStockIi().new Solution();

        int[] n = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 贪心算法：拿到每一段可以拿到的收益！
     */
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }

            // 定义状态、状态变化方程、初始值、确定值
            int length = prices.length;
            int[][] dp = new int[length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < length; i++) {
                // 其中0代表持有现金，1代表持有股票
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[length - 1][0];
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

    class SolutionB {

        /**
         * 通用动态规划
         */
        public int maxProfit(int[] prices) {

            if (prices.length < 2) {
                return 0;
            }

            // 定义状态、状态变化方程、初始值、确定值，其中0代表持有现金，1代表持有股票
            int length = prices.length;
            int[][] dp = new int[length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][i] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[length - 1][0];
        }


        /**
         * 贪心算法：拿到每一段可以拿到的收益！
         */
        public int maxProfit2(int[] prices) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += (prices[i] - prices[i - 1]);
                }
            }
            return maxProfit;
        }
    }

}
