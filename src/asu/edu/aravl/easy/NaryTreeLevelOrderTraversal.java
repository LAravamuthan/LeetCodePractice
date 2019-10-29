package asu.edu.aravl.easy;

import asu.edu.aravl.utility.MetaUtil.MetaMetaUtil.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Node> nodequ = new ArrayDeque<>();
        nodequ.add(root);
        List<List<Integer>> ansList = new ArrayList<>();
        while(!nodequ.isEmpty()){
            int levelNodes = nodequ.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < levelNodes; i++){
                Node nd = nodequ.poll();
                for(Node ndc : nd.children){
                    nodequ.add(ndc);
                }
                l.add(nd.val);
            }
            ansList.add(l);
        }
        return ansList;
    }
}
