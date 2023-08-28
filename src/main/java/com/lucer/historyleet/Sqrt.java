package com.lucer.historyleet;

import java.util.HashSet;

/**
 * x的平方根
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: liuchuan
 */
public class Sqrt {

    public static int sqrt(int a) {
        if (a == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(a));
        return (ans + 1) * (ans + 1) <=a ? ans + 1 : ans;
    }


    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrt2(int x) {

        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                ans = mid;
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }




}
