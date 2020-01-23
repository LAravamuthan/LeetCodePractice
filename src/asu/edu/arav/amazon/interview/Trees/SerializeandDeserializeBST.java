package asu.edu.arav.amazon.interview.Trees;

import asu.edu.aravl.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class SerializeandDeserializeBST {

    /**
     * @algo - postOrder Dfs
     * @time-complexity - O(n)
     * @space-complexity - O(nlgn)
     */


    public void postOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.val);
        sb.append(',');
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    public TreeNode reConstructFromBounds(Integer lower, Integer upper, List<Integer> values) {
        if (values.size() == 0) {
            return null;
        }
        Integer value = values.get(values.size() - 1);
        if ((lower == null || value >= lower) && (upper == null || value <= upper)) {
            values.remove(values.size() - 1);
            TreeNode node = new TreeNode(value);
            node.right = reConstructFromBounds(value, upper, values);
            node.left = reConstructFromBounds(lower, value, values);
            return node;
        }
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("")){
            return null;
        }
        List<Integer> values = new ArrayList<>();
        for (String value : data.split(",")) {
            values.add(Integer.valueOf(value));
        }
        return reConstructFromBounds(null, null, values);
    }

    public static void main(String[] args) {
        SerializeandDeserializeBST sdb = new SerializeandDeserializeBST();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String result = sdb.serialize(root);
        TreeNode newT = sdb.deserialize(result);
    }
}
