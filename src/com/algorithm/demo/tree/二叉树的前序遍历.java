package com.algorithm.demo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        TreeNode prev = null;
        while (pNode != null || !stack.isEmpty()) {
            if(pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                if (pNode.right == null || pNode.right == prev) {
                    list.add(pNode.val);
                    prev = pNode;
                    pNode = null;
                } else {
                    stack.push(pNode);
                    pNode = pNode.right;
                }
            }
        }
        return list;
    }

}
