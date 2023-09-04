package com.lucer.leetcode.leetcode.editor.cn;

//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」 定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果这个过程 结果为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 哈希表 数学 双指针 👍 1399 👎 0


import java.util.HashSet;

/*
 * 题目Id：202
 * 题目：快乐数
 * 日期：2023-09-01 17:46:47
 * @author liuchuan
 */
public class P202_HappyNumber {
    public static void main(String[] args) {
        Solution solution = new P202_HappyNumber().new Solution();
        solution.isHappy(19);

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            if (n == 0) {
                return false;
            }
            if (n == 1) {
                return true;
            }

            HashSet<Integer> set = new HashSet<>();
            set.add(n);

            while (true) {

                n = convert(n);
                if (n == 1) {
                    return true;
                }

                if (set.contains(n)) {
                    return false;
                }

                set.add(n);
            }

        }


        public int convert(int n) {
            if (n == 0) {
                return 0;
            }
            String str = String.valueOf(n);
            int result = 0;
            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                int value = Character.getNumericValue(temp);
                result += (value * value);
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
