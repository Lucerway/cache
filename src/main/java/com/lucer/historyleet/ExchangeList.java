package com.lucer.historyleet;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * @author: liuchuan
 */
public class ExchangeList {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // 如果left是奇数就继续往右边移动
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }

            // 如果right是偶数就继续左边移动
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            swap(nums, left, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 3, 2, 10, 6, 3, 8, 7, 2, 9};
        exchange(nums);
        System.out.println(Arrays.toString(nums));

    }


}
