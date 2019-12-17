package asu.edu.arav.amazon.interview.design;

import asu.edu.aravl.utility.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeandDeserializeBinaryTree2 {
    // Encodes a tree to a single string.

    List<TreeNode> nodes = new ArrayList<TreeNode>();
    public String serialize(TreeNode root) {
        preOrderTraversral(root);
        return  makeString();
    }
    public void preOrderTraversral(TreeNode node){
        if(node == null){
            nodes.add(null);
            return;
        }
        nodes.add(node);
        preOrderTraversral(node.left);
        preOrderTraversral(node.right);
    }
    public String makeString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nodes.size(); i++){
            if(i > 0){
                sb.append(",");
            }
            if(nodes.get(i) == null){
                sb.append("null");
            }else{
                sb.append(nodes.get(i).val);
            }
        }
        nodes.clear();
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodesStr = new ArrayList(Arrays.asList(data.split(",")));
        return buildTree(nodesStr);
    }
    public TreeNode buildTree(List<String> nodesStr){
        if(nodesStr.get(0).equals("null")){
            nodesStr.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodesStr.get(0)));
        nodesStr.remove(0);
        node.left = buildTree(nodesStr);
        node.right = buildTree(nodesStr);
        return node;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        SerializeandDeserializeBinaryTree2 sdbt2 = new SerializeandDeserializeBinaryTree2();
        sdbt2.serialize(root);

    }

}
