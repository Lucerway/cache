package com.leetcode.lucer.string;

import java.util.Arrays;

/**
 * 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * @author: liuchuan
 */
public class CheckInclusion {

    // 排序算法
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        s1 = sort(s1);
        int length1 = s1.length();
        int length2 = s2.length();
        for (int i = 0; i <= length2 - length1; i++) {
            String sub = s2.substring(i, i + length1);
            System.out.println("sub:" + sub);
            if (sort(sub).equals(s1)) {
                return true;
            }
        }
        return false;
    }


    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {

        System.out.println(checkInclusionV2( "bc", "adcab"));

    }


    public static boolean checkInclusionV2(String s1, String s2) {

        if (s2.length() < s1.length()) {
            return false;
        }

        int[] intS1 = new int[26];
        int[] intS2 = new int[26];

        // 完成初始化s1， s2的滑动窗口（s2后续需要滑动）
        for (int i = 0; i < s1.length(); i++) {
            intS1[s1.charAt(i) - 'a']++;
            intS2[s2.charAt(i) - 'a']++;
        }


        /*
         *  假设 s1 length  = 2; s2 length = 4
         *  循环  i= 0； i=1
         */
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(intS1, intS2)) {
                return true;
            }
            intS2[s2.charAt(i) - 'a']--;
            intS2[s2.charAt(i + s1.length()) - 'a']++;
        }
        return match(intS1, intS2);
    }


    public static boolean match(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }


}
