package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        // if both nodes are null just return
        if (t1 == null && t2 == null) {
            return t1;
        }

        // if t1 is null then t2 is the representative in the merged tree
        if (t1 == null && t2 != null) {
            t1 = t2;
            return t1;
        }

        // if t1 and t2 both are not null, add up their values and merge their childs
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        }

        // this will take care of the case where t1 != null but t2 == null
        return t1;
    }
}
