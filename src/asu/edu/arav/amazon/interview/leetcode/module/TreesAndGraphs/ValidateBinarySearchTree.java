package asu.edu.arav.amazon.interview.leetcode.module.TreesAndGraphs;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean isLeftBST = isValidBSR(root.left, root.val, null);
        boolean isRightBST = isValidBSR(root.right, null, root.val);

        return isLeftBST && isRightBST;
    }

    public boolean isValidBSR(TreeNode root, Integer maxB, Integer minB) {


        if (root == null) {
            return true;
        }
        boolean isLeftBST = isValidBSR(root.left, root.val, minB);
        boolean isRightBST = isValidBSR(root.right, maxB, root.val);
        if (!isLeftBST || !isRightBST) {
            return false;
        }
        if(minB != null){
            if(!(root.val > minB)){
                return false;
            }
        }
        if(maxB != null){
            if(!(root.val < maxB)){
                return false;
            }
        }
        return true;
    }
}
