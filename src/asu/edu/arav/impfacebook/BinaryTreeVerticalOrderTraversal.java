package asu.edu.arav.impfacebook;

import asu.edu.aravl.utility.TreeNode;

import java.util.*;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/binary-tree-vertical-order-traversal/
 */
public class BinaryTreeVerticalOrderTraversal {

    class TreeNodeWithValue {
        TreeNode node;
        int value;
        TreeNodeWithValue(TreeNode node, int value){
            this.node = node;
            this.value = value;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNodeWithValue> qu = new ArrayDeque<>();
        int min = 0;
        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        qu.offer(new TreeNodeWithValue(root, 0));
        while(!qu.isEmpty()){
            TreeNodeWithValue tNWV = qu.poll();
            List<Integer> l = map.getOrDefault(tNWV.value, new ArrayList<>());
            l.add(tNWV.node.val);
            if(tNWV.value < min){
                min = tNWV.value;
            }else if(tNWV.value > max){
                max = tNWV.value;
            }
            map.put(tNWV.value, l);
            if(tNWV.node.left!=null){
                qu.offer(new TreeNodeWithValue(tNWV.node.left, tNWV.value - 1));
            }

            if(tNWV.node.right!=null){
                qu.offer(new TreeNodeWithValue(tNWV.node.right, tNWV.value + 1));
            }
        }
        for(int i = min; i <= max; i++){
            ansList.add(map.get(i));
        }
        return ansList;
    }

}
