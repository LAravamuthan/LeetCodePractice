package asu.edu.aravl.easy;

import asu.edu.aravl.utility.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageofLevelsinBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Double> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int elementsInLevel = queue.size();
            double sum = 0.0;
            for(int i = 0; i < elementsInLevel; i++){
                TreeNode tr = queue.poll();
                sum+=tr.val;
                if(tr.left != null){
                    queue.offer(tr.left);
                }
                if(tr.right != null){
                    queue.offer(tr.right);
                }
            }
            ansList.add(sum/elementsInLevel);
        }
        return ansList;
    }
}
