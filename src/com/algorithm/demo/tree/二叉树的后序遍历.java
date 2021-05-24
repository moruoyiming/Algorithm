package com.algorithm.demo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的后序遍历 {

    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.add(0, top.val);
            if(top.left != null){
                stack.push(top.left);
            }
            if(top.right != null){
                stack.push(top.right);
            }
        }
        return result;
    }

}
