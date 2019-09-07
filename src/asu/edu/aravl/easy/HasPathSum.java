package asu.edu.aravl.easy;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.right == null && root.left == null){
            if(sum == root.val){
                return true;
            }else{
                return false;
            }
        }

        boolean isSumFromLeftTree = false;
        boolean isSumFromRightTree = false;

        if(root.left != null){
            isSumFromLeftTree = hasPathSum(root.left, sum - root.val);
        }

        if(root.right != null){
            isSumFromRightTree = hasPathSum(root.right, sum - root.val);
        }

        return isSumFromLeftTree || isSumFromRightTree;
    }
}
