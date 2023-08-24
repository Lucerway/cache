package com.lucer.leetcode.leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2876 👎 0


/*
 * 题目Id：14
 * 题目：最长公共前缀
 * 日期：2023-08-24 15:06:23
 *
 * @author liuchuan
 */
public class P14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14_LongestCommonPrefix().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            // 获取数组中的最小字符的长度
            String minStr = getMinLengthStr(strs);
            if (minStr == null || "".equals(minStr)) {
                return "";
            }

            StringBuilder stringBuilder = new StringBuilder();

            // 循环最小字符的每一位字符情况
            for (int i = 0; i < minStr.length(); i++) {
                char targetChar = minStr.charAt(i);

                // 标志计数器
                int count = 0;
                for (int j = 0; j < strs.length; j++) {
                    // 如果字符和比对字符相等
                    if (targetChar == strs[j].charAt(i)) {
                        // 标志计数器+1
                        count++;
                        // 标志计数器等于数组长度，代表这个字符属于公共字符，加入公共字字符集
                        if (count == strs.length) {
                            stringBuilder.append(targetChar);
                        }
                    } else {
                        // 如果字符不相等则直接返回结果
                        return stringBuilder.toString();
                    }
                }
            }
            return stringBuilder.toString();
        }

        /**
         * 获取最短字符的元素
         */
        private String getMinLengthStr(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            // 初始最小字符长度
            int minLenth = strs[0].length();
            for (int i = 0; i < strs.length; i++) {
                if (minLenth > strs[i].length()) {
                    minLenth = strs[i].length();
                }
            }


            // 如果最小字符是空串
            if (minLenth == 0) {
                return "";
            }

            for (int i = 0; i < strs.length; i++) {
                if (minLenth == strs[i].length()) {
                    return strs[i];
                }
            }
            return "";
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
