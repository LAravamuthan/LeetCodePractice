package asu.edu.arav.amazon.interview.design;

import asu.edu.aravl.utility.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    // this list will include nulls too as it has to be there for setting leaf nodes
    List<String> nodes = new ArrayList<>();

    public String serialize(TreeNode root) {
        preOrderTraversal(root);
        return makeString();
    }

    // make the serialised string from the list
    public String makeString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nodes.size(); i++){
            if(i==0){
                sb.append(nodes.get(i));
                continue;
            }
            sb.append(",");
            sb.append(nodes.get(i));
        }
        nodes.clear();
        return sb.toString();
    }

    // dfs preorderOrder traversal of the tree and appending the values in list
    public void preOrderTraversal(TreeNode node){
        if(node == null){
            nodes.add("null");
            return;
        }
        // add it self if not null or else add null
        nodes.add(Integer.toString(node.val));
        // post addig self continue to other branches
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] nodesStr = data.split(",");
        nodes = new ArrayList<String>(Arrays.asList(nodesStr));
        return buildTree();
    }

    public TreeNode buildTree(){
        // if the top element of the arrayList is null then return null
        // and also remove it
        if(nodes.get(0).equals("null")){
            nodes.remove(0);
            return null;
        }
        // else make current TreeNode from the top element,
        // remove it from the nodes list and make the left and right tree
        TreeNode node = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        node.left = buildTree();
        node.right = buildTree();
        return node;
    }
}
