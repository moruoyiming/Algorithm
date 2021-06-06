package com.algorithm.demo.tree;

/**
 * 155 · 二叉树的最小深度
 * 题目题解笔记讨论排名
 * 描述
 * 给定一个二叉树，找出其最小深度。
 * 二叉树的最小深度为根节点到最近叶子节点的最短路径上的节点数量。
 * 样例
 * 样例 1:
 * 输入: {}
 * 输出: 0
 * 样例 2:
 * 输入:  {1,#,2,3}
 * 输出: 3
 * 解释:
 * 1
 * \
 * 2
 * /
 * 3
 * 它将被序列化为 {1,#,2,3}
 */
public class 二叉树的最小深度 {

    public static void main(String[] args) {

    }

    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

}
