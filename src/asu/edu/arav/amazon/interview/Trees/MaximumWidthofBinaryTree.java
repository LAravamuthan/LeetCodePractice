package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class MaximumWidthofBinaryTree {
    /**
     * @algo - Tree DFS
     * @time-complexity - O(n)
     * @space-complexity - O(logn)
     */
    int maxWidth = Integer.MIN_VALUE;
    Map<Integer, Integer> levelCountMap = new HashMap<Integer, Integer>();

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0, 0);
        return maxWidth;
    }

    public void dfs(TreeNode node, int level, int pos) {
        if (node == null) {
            return;
        }
        if (!levelCountMap.containsKey(level)) {
            levelCountMap.put(level, pos);
        }
        maxWidth = Math.max(pos - levelCountMap.get(level) + 1, maxWidth);
        dfs(node.left, level + 1, 2 * pos);
        dfs(node.right, level + 1, 2 * pos + 1);
    }
}
