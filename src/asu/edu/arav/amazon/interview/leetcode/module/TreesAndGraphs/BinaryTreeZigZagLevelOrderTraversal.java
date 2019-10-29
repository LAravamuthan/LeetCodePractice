package asu.edu.arav.amazon.interview.leetcode.module.TreesAndGraphs;

import asu.edu.aravl.utility.TreeNode;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> qe = new ArrayDeque<>();
        qe.offer(root);
        List<List<Integer>> ansList = new ArrayList<>();
        boolean isReverse = false;
        while (!qe.isEmpty()) {
            int levelNumbers = qe.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < levelNumbers; i++) {
                TreeNode tr = qe.poll();
                if(tr.left != null){
                    qe.add(tr.left);
                }
                if(tr.right != null){
                    qe.add(tr.right);
                }
                if(isReverse){
                    l.add(0, tr.val);
                }else{
                    l.add(tr.val);
                }
            }
            ansList.add(l);
            isReverse = !isReverse;
        }
        return ansList;
    }
}
