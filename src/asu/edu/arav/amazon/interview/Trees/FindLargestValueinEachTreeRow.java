package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
public class FindLargestValueinEachTreeRow {


    /*similar problem we did in BFS manner trying the dfs version
     * Time complexity - O(n) and Space complexity - O(1) or stack used for
     * recursion  - O(lgn) i.e the height of the tree*/

    public List<Integer> res = new ArrayList<Integer>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfsStyleMaxFinding(root, 0);
        return res;
    }

    public void dfsStyleMaxFinding(TreeNode node, int depth) {
        if (depth == res.size()) {
            res.add(node.val);
        } else {
            res.set(depth, Math.max(res.get(depth), node.val));
        }
        if (node.left != null) {
            dfsStyleMaxFinding(node.left, depth + 1);
        }
        if (node.right != null) {
            dfsStyleMaxFinding(node.right, depth + 1);
        }
    }
}
