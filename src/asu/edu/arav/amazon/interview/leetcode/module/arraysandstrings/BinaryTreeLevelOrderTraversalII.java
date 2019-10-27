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
 * @Link https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversalII {

    List<List<Integer>> ansListRecur = new ArrayList<>();
    // BFS version with queue
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> nodepq = new ArrayDeque<>();
        nodepq.add(root);

        List<List<Integer>> ansList = new ArrayList<>();

        while (!nodepq.isEmpty()) {
            int sameLevelEle = nodepq.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < sameLevelEle; i++) {
                TreeNode tr = nodepq.poll();
                if (tr.left != null) {
                    nodepq.add(tr.left);
                }
                if (tr.right != null) {
                    nodepq.add(tr.right);
                }
                levelList.add(tr.val);
            }
            ansList.add(0, levelList);
        }

        return ansList;
    }

    // DFS type solution with recurion

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        dfsHelper(root, 0);
        return ansListRecur;
    }

    public void dfsHelper(TreeNode root, int level){
        if(level == ansListRecur.size()){
            ansListRecur.add(0, new ArrayList<>());
        }
        if(root.left != null){
            dfsHelper(root.left, level+1);
        }
        if(root.right != null){
            dfsHelper(root.right, level+1);
        }
        ansListRecur.get(ansListRecur.size() - level - 1).add(root.val);
    }





}
