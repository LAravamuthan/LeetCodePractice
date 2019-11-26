package asu.edu.arav.amazon.interview.dfs;


import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/house-robber-iii/
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] maxes = dfsHelper(root);
        // once we get the two maxes of root node, return the max along them
        return Math.max(maxes[0], maxes[1]);
    }

    public int[] dfsHelper(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        // for every node return max including itself and max not including itself
        // maxes from left and right
        int[] left = dfsHelper(node.left);
        int[] right = dfsHelper(node.right);
        // at the 0th index we have the max inculding the current node
        int[] nodeMaxes = new int[2];
        // if we include the node val then we add the max excluding of left and right subtree
        nodeMaxes[0] = left[1] + right[1] + node.val;
        // if we exclude the node val then we add the max of  excluding and including of left and right subtree
        nodeMaxes[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return nodeMaxes;
    }
}
