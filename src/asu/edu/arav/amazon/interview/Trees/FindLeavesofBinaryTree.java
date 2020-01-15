package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-leaves-of-binary-tree/
 */
public class FindLeavesofBinaryTree {

    /**
     * @algo - Tree DFS style BackTracking
     * @time-complexity - O(n)
     * @space-complexity - O(log n)
     */

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return res;
        }
        bfsBackTrack(root);
        return res;
    }

    public int bfsBackTrack(TreeNode node) {
        int leftDepth = node.left != null ? bfsBackTrack(node.left) : -1;
        int rightDepth = node.right != null ? bfsBackTrack(node.right) : -1;
        int level = Math.max(leftDepth, rightDepth) + 1;
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        return level;
    }
}
