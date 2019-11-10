package asu.edu.arav.amazon.interview.leetcode.module.TreesAndGraphs;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return maxSum;
        }
        dfsMaxSumRecursion(root);
        return maxSum;
    }

    public int dfsMaxSumRecursion(TreeNode root){
        if(root == null){
            return 0;
        }
        // this will calculate Maximum path from left subtree
        // answer to the question I ask at the end is in the next line
        // it is simple dont iclude negative people guys simple
        int leftMaxSum = Math.max(dfsMaxSumRecursion(root.left), 0);
        // this will calculate Maximum path from right subtree
        int rightMaxSum = Math.max(dfsMaxSumRecursion(root.right), 0);
        // the max sum possible from tree with root as node
        // is node.val + leftMAxSum + rightMaxSum
        maxSum = Math.max(root.val + leftMaxSum + rightMaxSum, maxSum);
        // wat it returns important it can return either left subtree path or
        // right subtree path so chooose one but what about the case where it has both
        // valued childs ???
        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }

}
