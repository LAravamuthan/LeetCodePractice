package asu.edu.arav.amazon.interview.leetcode.module.TreesAndGraphs;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterofBinaryTree {
    int depth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return depth;
        }
        maxFanOut(root);
        return depth;
    }

    public int maxFanOut(TreeNode root){
        if (root == null){
            return 0;
        }
        // depth from left subTree
        int ld = maxFanOut(root.left);
        // depth from right subTree
        int rd = maxFanOut(root.left);
        // max depth would be left depth + right depth
        // from current node
        depth = Math.max(depth, ld + rd);
        // to its parent it is going include itself and
        // the max of either left depth or right depth
        return 1 + Math.max(ld, rd);
    }
}
