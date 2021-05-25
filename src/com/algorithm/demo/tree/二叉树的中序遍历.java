package com.algorithm.demo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述
 * 给出一棵二叉树,返回其中序遍历。
 * 样例
 * 样例 1：
 * 输入：
 * 二叉树 = {1,2,3}
 * 输出：
 * [2,1,3]
 * 解释：
 * 1
 * /  \
 * 2     3
 * 它将被序列化为{1,2,3}中序遍历
 * 样例 2：
 * 输入：
 * 二叉树 = {1,#,2,3}
 * 输出：
 * [1,3,2]
 * 解释：
 * 1
 * \
 * 2
 * /
 * 3
 * 它将被序列化为{1,#,2,3}中序遍历
 */
public class 二叉树的中序遍历 {


    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            result.add(node.val);

            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return result;
    }

    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }
}
