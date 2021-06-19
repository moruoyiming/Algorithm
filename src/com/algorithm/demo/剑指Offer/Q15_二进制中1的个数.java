package com.algorithm.demo.剑指Offer;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，
 * 有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * 如果 n & 1 = 0, 则 n 的最后一位是 0 ；如果 n & 1 = 1, 则 n 的最后一位是 1。
 * <p>
 * 基于这两个特点，可以统计出最后一位是否为 1，如果为 1，则更新记录统计的 1 的个数，然后将 n 右移一位，
 * 这样就能统计到原来 n 的倒数第二位，依次操作；如果为 0，则不需要更新记录统计的 1 的个数，
 * 直接将 n 右移一位。
 * <p>
 * 符号	描述	示例	运算规则
 * &	与	A & B	A 和 B 都为 1 时，结果为 1
 * |	或	A | B	A 和 B 都为 0 时，结果为 0
 * ^	异或	A ^ B	A 和 B 相同为 0 ，相异为 1
 * ~	取反	~A	0 变 1 ，1 变 0
 * <<	左移	A<<	全部左移若干位，高位丢弃，低位补 0
 * >>	右移	A>>	全部右移若干位，对无符号数，高位补 0 ，有符号数，各编译器处理方法不一样，有的补符号位（算术右移），有的补 0（逻辑右移）
 */
public class Q15_二进制中1的个数 {

    /**
     * 时间复杂度为 O(log2n)。
     * 空间复杂度为 O(1)。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        //用来保存统计到的结果
        int res = 0;
        //不断的右移n ， 直到为 0
        while (n != 0) {
            //统计结果
            res = res + (n & 1);
            //无符号右移 1 位
            n = n >>> 1;
        }
        return res;
    }


}
