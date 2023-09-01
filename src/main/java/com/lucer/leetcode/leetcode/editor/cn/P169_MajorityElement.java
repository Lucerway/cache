package com.lucer.leetcode.leetcode.editor.cn;

//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 1930 👎 0


import java.util.HashMap;
import java.util.Map;

/*
 * 题目Id：169
 * 题目：多数元素
 * 日期：2023-08-30 20:22:07
 * @author liuchuan
 */
public class P169_MajorityElement {
    public static void main(String[] args) {
        Solution solution = new P169_MajorityElement().new Solution();

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            Map.Entry<Integer, Integer> maxEntry = null;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                    maxEntry = entry;
                }
            }
            return maxEntry.getKey();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class SolutionB {
        public int majorityElement(int[] nums) {
            int winner = nums[0];
            int count = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == winner) {
                    count++;
                } else if (count == 0) {
                    winner = nums[i];
                    count++;
                } else {
                    count--;
                }

            }
            return winner;
        }
    }

}
