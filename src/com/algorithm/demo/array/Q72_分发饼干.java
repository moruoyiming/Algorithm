package com.algorithm.demo.array;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 示例 1:
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 *
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 */
public class Q72_分发饼干 {

    /**
     * 方法一：排序 + 贪心
     * 为了尽可能满足最多数量的孩子，从贪心的角度考虑，应该按照孩子的胃口从小到大的顺序依次满足每个孩子，且对于每个孩子，
     * 应该选择可以满足这个孩子的胃口且尺寸最小的饼干。证明如下。
     *假设有 mm 个孩子，胃口值分别是 g1 到 gm，有 n 块饼干，尺寸分别是 s1 到 sn，满足 gi ≤ gi+1 和 sj ≤s j+1 ，
     * 其中 1≤i<m，1≤j<n。
     *假设在对前 i−1 个孩子分配饼干之后，可以满足第 ii 个孩子的胃口的最小的饼干是第 j 块饼干，即 sj 是剩下的饼干中满足 gi ≤ sj的最小值，
     * 最优解是将第 j 块饼干分配给第 i 个孩子。如果不这样分配，考虑如下两种情形：
     * 如果 i<m 且 gi+1 ≤sj也成立，则如果将第 j 块饼干分配给第 i+1 个孩子，且还有剩余的饼干，则可以将第 j+1 块饼干分配给第 i 个孩子，
     * 分配的结果不会让更多的孩子被满足；
     *
     * 如果 j<n，则如果将第 j+1 块饼干分配给第 i 个孩子，当 gi+1 ≤ sj时，可以将第 j 块饼干分配给第 i+1 个孩子，分配的结果不会让更多的孩子被满足；
     * 当 gi+1 > sj时，第 j 块饼干无法分配给任何孩子，因此剩下的可用的饼干少了一块，因此分配的结果不会让更多的孩子被满足，甚至可能因为少了一块可用的
     * 饼干而导致更少的孩子被满足。
     *
     * 首先对数组 g 和 s 排序，然后从小到大遍历 g 中的每个元素，对于每个元素找到能满足该元素的 s 中的最小的元素。具体而言，
     * 令 i 是 g 的下标，j 是 s 的下标，初始时 i 和 j 都为 0，进行如下操作。
     *
     * 对于每个元素 g[i]g[i]，找到未被使用的最小的 j 使得 g[i]≤s[j]，则 s[j] 可以满足 g[i]。由于 g 和 s 已经排好序，
     * 因此整个过程只需要对数组 g 和 s 各遍历一次。当两个数组之一遍历结束时，说明所有的孩子都被分配到了饼干，或者所有的饼干
     * 都已经被分配或被尝试分配（可能有些饼干无法分配给任何孩子），此时被分配到饼干的孩子数量即为可以满足的最多数量。
     *
     *
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for(int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++ , j++){
            while(j < numOfCookies && g[i] > s[j]){
                j++;
            }
            if(j < numOfCookies){
                count++;
            }
        }
        return count;
    }

}
