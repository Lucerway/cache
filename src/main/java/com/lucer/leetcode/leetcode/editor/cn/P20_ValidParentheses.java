package com.lucer.leetcode.leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4104 👎 0


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * 题目Id：20
 * 题目：有效的括号
 * 日期：2023-08-24 16:30:01
 * @author liuchuan
 */
public class P20_ValidParentheses {
    public static void main(String[] args) {
        /*
         * 栈的用法：是左括号就入栈，是右括号的话就出栈一个左括号，看看是否这2个括号是一对的
         */
        Solution solution = new P20_ValidParentheses().new Solution();
        solution.isValid("){");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s == null || "".equals(s)) {
                return false;
            }
            if (s.length() % 2 != 0) {
                return false;
            }

            Map<Character, Character> map = toMap();

            Deque<Character> stack = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {

                Character charFlag = s.charAt(i);

                // 如果是左括号就入栈
                if (map.containsValue(charFlag)) {
                    stack.push(charFlag);
                } else {
                    // 如果是右括号就出栈，判断是否是一对的括号
                    if (stack.isEmpty()) {
                        return false;
                    }

                    Character popChar = stack.pop();
                    // 如果pop出来的左括号不匹配
                    if (map.get(charFlag) != popChar) {
                        return false;
                    }
                }

            }

            return stack.isEmpty();
        }


        /**
         * 括号集合
         * key：右括号
         * value: 左括号
         */
        private Map<Character, Character> toMap() {
            Map<Character, Character> map = new HashMap<>();
            map.put('}', '{');
            map.put(')', '(');
            map.put(']', '[');
            return map;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
