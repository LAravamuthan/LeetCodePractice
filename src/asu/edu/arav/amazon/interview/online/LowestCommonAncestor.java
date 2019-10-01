package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        TreeNode res = null;

        if(p.val == root.val || q.val == root.val) {
            return root;
        }else if((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)){
            return root;
        }else if ((p.val > root.val && q.val > root.val)){
            res = lowestCommonAncestor(root.right, p, q);
        }else if ((p.val < root.val && q.val < root.val)){
            res = lowestCommonAncestor(root.left, p, q);
        }
        return res;
    }

}
