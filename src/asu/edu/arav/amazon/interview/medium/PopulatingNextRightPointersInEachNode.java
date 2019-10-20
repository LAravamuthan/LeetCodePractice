package asu.edu.arav.amazon.interview.medium;

import asu.edu.aravl.utility.MetaUtil.Node;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {

        Node levelStart = root;
        while(levelStart != null){
            Node toBeProcessedNode = levelStart;
            while(toBeProcessedNode != null){
                if(toBeProcessedNode.left != null){
                    toBeProcessedNode.left.next = toBeProcessedNode.right;
                }
                if(toBeProcessedNode.right != null && toBeProcessedNode.next !=null){
                    toBeProcessedNode.right.next = toBeProcessedNode.next.left;
                }
                toBeProcessedNode = toBeProcessedNode.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }

}

