package com.algorithm.demo.array;

import static com.algorithm.demo.LogUtils.log;
import static com.algorithm.demo.LogUtils.log2;

/**
 * 合并排序数组
 * 合并两个排序的整数数组A和B变成一个新的数组。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入：[1, 2, 3]  3  [4,5]  2
 * 输出：[1,2,3,4,5]
 * 解释:
 * 经过合并新的数组为[1,2,3,4,5]
 * 样例 2:
 * <p>
 * 输入：[1,2,5] 3 [3,4] 2
 * 输出：[1,2,3,4,5]
 * 解释：
 * 经过合并新的数组为[1,2,3,4,5]
 * 注意事项
 * 你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素。
 */
public class 合并排序数组 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};
//        int[] a = {2, 5, 8};
//        int[] b = {3,6};
        mergeSortedArray(a, 3, b, 2);
    }


    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int pa = 0, pb = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (pa < m || pb < n) {
            if (pa == m) {
                cur = B[pb++];
            } else if (pb == n) {
                cur = A[pa++];
            } else if (A[pa] < B[pb]) {
                cur = A[pa++];
            } else {
                cur = B[pb++];
            }
            sorted[pa + pb - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            A[i] = sorted[i];
        }

    }

}
