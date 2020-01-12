package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // Here is the code where we do BFS and select the last element at each level
        Queue<TreeNode> queueNode = new ArrayDeque<TreeNode>();

        List<Integer> ansList = new ArrayList<>();
        queueNode.offer(root);

        while (!queueNode.isEmpty()) {
            int levelSize = queueNode.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queueNode.poll();
                if (node.left != null) queueNode.offer(node.left);
                if (node.right != null) queueNode.offer(node.right);
                if (i == levelSize - 1) {
                    ansList.add(node.val);
                }
            }
        }
        return ansList;
    }
}
