package com.algorithm.demo.贪心算法;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
 * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
 * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的 最多 种类数。
 * 示例 1：
 * 输入：candyType = [1,1,2,2,3,3]
 * 输出：3
 * 解释：Alice 只能吃 6 / 2 = 3 枚糖，由于只有 3 种糖，她可以每种吃一枚。
 * 示例 2：
 * 输入：candyType = [1,1,2,3]
 * 输出：2
 * 解释：Alice 只能吃 4 / 2 = 2 枚糖，不管她选择吃的种类是 [1,2]、[1,3] 还是 [2,3]，她只能吃到两种不同类的糖。
 * 示例 3：
 * 输入：candyType = [6,6,6,6]
 * 输出：1
 * 解释：Alice 只能吃 4 / 2 = 2 枚糖，尽管她能吃 2 枚，但只能吃到 1 种糖。
 */
public class 分糖果 {

    /**
     *方法一：贪心
     * 一方面，设糖果数量为 n，由于妹妹只能分到一半的糖果，所以答案不会超过 n / 2；另一方面，设这些糖果一共有 m 种，答案也不会超过 m。
     * 若 m ≤ n / 2 ，则可以每种糖果至少分一颗给妹妹，此时答案为 m；
     * 若 m > n / 2 ，则妹妹只能分到 n / 2 种糖果，每种糖果分一颗，此时答案为 n / 2。
     * 综上所述，答案为 min(m, n / 2)。
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 是数组 candies 的长度。
     * 空间复杂度：O(n)。哈希表需要 O(n) 的空间。
     */
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int candy : candyType){
            set.add(candy);
        }
        return Math.min(set.size(),candyType.length / 2);
    }

}
