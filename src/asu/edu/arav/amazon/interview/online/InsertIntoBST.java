package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoBST {

    //recursive approach
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (val > root.val && root.right != null) {
            insertIntoBST(root.right, val);
        } else if (val < root.val && root.left != null) {
            insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = new TreeNode(val);
        } else if (val < root.val) {
            root.left = new TreeNode(val);
        }
        return root;
    }

    //iterative approach
    public TreeNode insertIntoBSTItr(TreeNode root, int val) {
        TreeNode temp = root;
        while (temp != null) {
            if(val < temp.val){
                if(temp.left == null){
                    temp.left = new TreeNode(val);
                    return root;
                }
                else{
                    temp = temp.left;
                }
            }else{
                if(temp.right == null){
                    temp.right = new TreeNode(val);
                    return root;
                }
                else{
                    temp = temp.right;
                }
            }
        }
        return new TreeNode(val);
    }
}
