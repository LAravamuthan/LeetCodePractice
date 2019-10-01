package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class SearchBSTForAKey {

    // Recursive
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode res;
        if (root == null) {
            return null;
        } else if (root.val == val) {
            return root;
        } else if (val < root.val) {
            res = searchBST(root.left, val);
        } else {
            res = searchBST(root.right, val);
        }
        return res;
    }

    //Iterative
    public TreeNode searchBSTItr(TreeNode root, int val) {
        TreeNode temp = root;
        while(temp!=null){
            if(temp.val == val){
                return temp;
            }else if(temp.val > val){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return temp;
    }
}
