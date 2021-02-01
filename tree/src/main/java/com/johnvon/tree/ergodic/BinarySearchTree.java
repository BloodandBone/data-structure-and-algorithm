package com.johnvon.tree.ergodic;

import com.johnvon.tree.util.TreeNode;

/**
 * @Description
 * @Author: johnvon
 * @Date: 2021/2/1 13:19
 */
public class BinarySearchTree {
    private TreeNode tree;

    //查找
    public TreeNode find(int data) {
        TreeNode p = tree;
        while (p != null) {
            if (data < p.val) {
                p = p.left;
            } else if (data > p.val) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    //插入
    public void insert(int data) {
        if (tree == null) {
            return;
        }

        TreeNode p = tree;
        while (p != null) {
            if (data > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    //删除
    public void delete(int data) {
        //P指向要删除的节点,初始化指向根节点
        TreeNode p = tree;
        //pp记录的是p的父节点
        TreeNode pp = null;
        while (p != null && p.val != data) {
            pp = p;
            if (data > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
            if (p == null) {
                //没有找到
                return;
            }
            //要删除的节点有两个子节点
            if (p.left != null && p.right != null) {
                //查找右子树中的最小节点
                TreeNode minP = p.right;
                //minPP表示minP的父节点
                TreeNode minPP = p;
                while (minP.left != null) {
                    minPP = minP;
                    minP = minP.left;
                }
                //将minP的数据替换到p中
                p.val = minP.val;
                //下面就变成删除minP了
                pp = minPP;
            }
            //删除节点是叶子节点或者仅有一个子节点
            //p的子节点
            TreeNode child;
            if (p.left != null) {
                child = p.left;
            } else if (p.right != null) {
                child = p.right;
            } else {
                child = null;
            }

            //删除的是根节点
            if (pp == null) {
                tree = child;
            } else if (pp.left == p) {
                pp.left = child;
            } else {
                pp.right = child;
            }
        }


    }
}
