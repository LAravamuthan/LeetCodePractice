package asu.edu.arav.amazon.interview.leetcode.module.arraysandstrings;

import asu.edu.aravl.utility.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    // classic level order traversal so I think its enough to just write this
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        List<List<Integer>> ansList = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<Integer>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode tr = queue.poll();
                l.add(tr.val);
                // Left has to be the first child you put first in the queue
                // Do remember that this is not a Graph but binary tree
                if (tr.left != null) {
                    queue.add(tr.left);
                }
                if (tr.right != null) {
                    queue.add(tr.right);
                }
            }
            ansList.add(l);
        }
        return ansList;
    }
}
