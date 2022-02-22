package com.algorithm.demo.search;

/**
 * 441. 排列硬币
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * <p>
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 * <p>
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 * 1
 * 1 1
 * 1 1 _
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 * 1
 * 1 1
 * 1 1 1
 * 1 1 _ _
 */
public class 排列硬币 {

    /**
     * 方法一：二分查找
     * 思路和算法
     * 根据等差数列求和公式可知，前 k 个完整阶梯行所需的硬币数量为
     * total = k * (k + 1) / 2;
     *
     * 复杂度分析
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     */
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


}
