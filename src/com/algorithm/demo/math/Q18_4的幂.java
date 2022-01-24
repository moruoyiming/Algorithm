package com.algorithm.demo.math;

/**
 * 342. 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 */
public class Q18_4的幂 {


    /**
     * 思路与算法
     * 如果 n 是 4 的幂，那么它可以表示成 4^x的形式，我们可以发现它除以 3 的余数一定为 1，即：
     * 如果 n 是 2 的幂却不是 4 的幂，那么它可以表示成 4^x × 2 的形式，此时它除以 3 的余数一定为 2。
     * 因此我们可以通过 n 除以 3 的余数是否为 1 来判断 n 是否是 4 的幂。
     *
     * 时间复杂度：O(1)。
     * 空间复杂度：O(1)。
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }

}
