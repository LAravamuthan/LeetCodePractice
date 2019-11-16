package asu.edu.arav.amazon.interview.f2f;

import asu.edu.aravl.utility.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/same-tree/
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // if both are null return true at any point in recursion
        if (p == null && q == null) {
            return true;
        }

        // if either one of them is null after the previous condition return false
        if (p == null || q == null) {
            return false;
        }
        // check value and subtree
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // helper method to tell you whether a pair of nodes are equal
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val;
    }

    // lets try the iterative method
    public boolean isSameTree1(TreeNode p, TreeNode q) {

        // if both are null return true at any point in recursion
        if (p == null && q == null) {
            return true;
        }

        // if either one of them is null after the previous condition return false
        if (p == null || q == null) {
            return false;
        }

        if (!check(p, q)) {
            return false;
        }

        Queue<TreeNode> pQue = new ArrayDeque<TreeNode>();
        Queue<TreeNode> qQue = new ArrayDeque<TreeNode>();

        pQue.offer(p);
        qQue.offer(q);

        // while pQue is not empty
        // pop each node check it satifies the conditions for being a same tree
        // if it is add children but if both children from different are part
        // satisfactroy condition
        // keep going to popping
        //
        while (!pQue.isEmpty()) {
            p = pQue.poll();
            q = qQue.poll();

            if(!check(p.left, q.left)){
                return false;
            }
            if(p.left != null){
                pQue.offer(p.left);
                qQue.offer(q.left);
            }

            if(!check(p.right, q.right)){
                return false;
            }
            if(p.right != null){
                pQue.offer(p.right);
                qQue.offer(q.right);
            }
        }
        return true;
    }

}
