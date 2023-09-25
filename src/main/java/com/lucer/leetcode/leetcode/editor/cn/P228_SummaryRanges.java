package com.lucer.leetcode.leetcode.editor.cn;

//给定一个 无重复元素 的 有序 整数数组 nums 。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
//nums 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
//
// Related Topics 数组 👍 352 👎 0


import java.util.ArrayList;
import java.util.List;

/*
 * 题目Id：228
 * 题目：汇总区间
 * 日期：2023-09-25 16:22:56
 * @author liuchuan
 */
public class P228_SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new P228_SummaryRanges().new Solution();

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution2 {
        public List<String> summaryRanges(int[] nums) {
            //使用双指针技巧解题

            List<String> resultList = new ArrayList<String>();
            int i = 0;
            while (i < nums.length) {
                int pointA = i;
                i++;
                while (i < nums.length && nums[i - 1] + 1 == nums[i]) {
                    i++;
                }
                int pointB = i - 1;
                StringBuilder temp = new StringBuilder(Integer.toString(nums[pointA]));
                if (pointA < pointB) {
                    temp.append("->");
                    temp.append(nums[pointB]);
                }
                resultList.add(temp.toString());
            }
            return resultList;
        }
    }

}
