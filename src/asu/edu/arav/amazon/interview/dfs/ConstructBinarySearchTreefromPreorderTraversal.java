package asu.edu.arav.amazon.interview.dfs;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class ConstructBinarySearchTreefromPreorderTraversal {

    /**
     * @algo - BFS
     * @time-complexity - O(N)
     * @space-complexity - O(logN)
     */

    int idx = 0;
    int[] preorder = null;

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        this.preorder = preorder;
        return dfsHelper(null, null);
    }

    public TreeNode dfsHelper(Integer min, Integer max) {
        if (idx == preorder.length) return null;
        int val = preorder[idx];
        if (min != null && val < min) return null;
        if (max != null && val > max) return null;
        TreeNode node = new TreeNode(preorder[idx++]);
        node.left = dfsHelper(min, node.val);
        node.right = dfsHelper(node.val, max);
        return node;
    }

    public static void main(String[] args) {
        ConstructBinarySearchTreefromPreorderTraversal cis = new ConstructBinarySearchTreefromPreorderTraversal();
        int[] input = {8, 5, 1, 7, 10, 12};
        cis.bstFromPreorder(input);
    }


}
