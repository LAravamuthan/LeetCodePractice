package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {

    /**
     * @algo - Tree Dfs
     * @time-complexity - O(n)
     * @space-complexity - O(logn)
     */

    List<List<Integer>> res = new ArrayList<>();
    int targetSum = -1;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        this.targetSum = sum;
        dfs(root, 0, new ArrayList<Integer>());
        return res;
    }

    public void dfs(TreeNode node, int curSum, List<Integer> path) {
        curSum += node.val;
        path.add(node.val);
        if (curSum >= this.targetSum) {
            if (curSum == this.targetSum && node.left == null && node.right == null) {
                res.add(new ArrayList<Integer>(path));
            }
            return;
        }
        if (node.left != null) {
            dfs(node.left, curSum, path);
        }
        if (node.right != null) {
            dfs(node.right, curSum, path);
        }
        path.remove(path.size() - 1);
    }
}
