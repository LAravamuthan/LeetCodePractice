package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/inorder-successor-in-bst/
 */
public class InorderSuccessorinBST {


    /**
     * @algo DFS recursive
     * @time-complexity - O(n)
     * @space-complexity - O(log n)
     */

    TreeNode ans = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val == p.val) {
            if (root.right == null) return ans;
            TreeNode cur = root.right;
            while (cur != null) {
                ans = cur;
                cur = cur.left;
            }
            return ans;
        }
        if (p.val > root.val) {
            return inorderSuccessor(root.right, p);
        }
        ans = root;
        return inorderSuccessor(root.left, p);
    }
}
