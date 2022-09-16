package com.algorithm.demo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 */
public class 左叶子之和 {

    /**
     * 方法一：深度优先搜索
     * 时间复杂度：O(n)，其中 nn 是树中的节点个数。
     * 空间复杂度：O(n)。空间复杂度与深度优先搜索使用的栈的最大深度相关。在最坏的情况下，树呈现链式结构，深度为 O(n)O(n)，对应的空间复杂度也为 O(n)O(n)。
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }


    public int dfs(TreeNode node){
        int ans = 0;
        if(node.left != null){
            ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
        }
        if(node.right != null && !isLeafNode(node.right)){
            ans += dfs(node.right);
        }
        return ans;
    }


    public boolean isLeafNode(TreeNode node){
        return node.left == null && node.right == null;
    }

    /**
     * 方法二：广度优先搜索.md
     * 时间复杂度：O(n),其中 nn 是树中的节点个数。
     * 空间复杂度：O(n)。空间复杂度与广度优先搜索使用的队列需要的容量相关，为 O(n)。
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                if(isLeafNode(node.left)){
                    ans += node.left.val;
                }else{
                    queue.offer(node.left);
                }
            }
            if(node.right != null){
                if(!isLeafNode(node.right)){
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

}
