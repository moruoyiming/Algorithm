package com.algorithm.demo.array;

import com.algorithm.demo.LogUtils;

/**
 * 1334. 旋转数组
 * 给定一个数组，将数组向右移动k步，其中k为非负数。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转1步: [7,1,2,3,4,5,6]
 * 向右旋转2步: [6,7,1,2,3,4,5]
 * 向右旋转3步: [5,6,7,1,2,3,4]
 * 样例 2:
 * <p>
 * 输入: [-1,-100,3,99], k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转1步: [99,-1,-100,3]
 * 向右旋转2步: [3,99,-1,-100]
 * 挑战
 * 给出尽可能多的解决办法, 至少有三种方法可以解决这个问题.
 * 能够用O(1)的时间复杂度解决问题吗?
 */
public class 旋转数组 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] temp = rotate(nums, 3);
        LogUtils.log(temp);

    }

    /**
     * @param nums: an array
     * @param k:    an integer
     * @return: rotate the array to the right by k steps
     */
    public static int[] rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int length = nums.length;
        if (k % length == 0) {
            return nums;
        }
        int[] temp = new int[nums.length];
        k %= length;
        for (int i = 0; i < nums.length; i++) {//3 5
            if (i < k) {
                temp[i] = nums[nums.length - k + i];//2 6
            } else {
                temp[i] = nums[i - k];//2 6
            }
        }
        return temp;
    }

}
