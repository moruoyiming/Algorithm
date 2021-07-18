package com.algorithm.demo.剑指Offer;

import com.algorithm.demo.tree.TreeNode;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 先把一棵二叉树学历恶化成一个前序遍历序列和一个中序遍历序列，然后再反序列化时通过这两个序列重构出原二叉树。
 * 缺点：一是该方法要二叉树中不能有数值重复的节点。
 *      二是只有当两个序列中所有数据都读出后才能开始反序列化。
 *                  1
 *             2         3
 *        4          5        6
 *  1,2,4,1,
 *
 */
public class Q37_序列化二叉树 {

    public void Serialize(TreeNode pRoot,String str){
        if(pRoot == null){
            return ;
        }
    }

}
