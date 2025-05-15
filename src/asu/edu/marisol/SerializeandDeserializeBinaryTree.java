package asu.edu.marisol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SerializeandDeserializeBinaryTree {

    /**
     * DFS approach for making the string.
     * Encodes a tree to a single string.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("*,");
            return;
        }

        sb.append(node.val + ",");
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    /**
     * Binary Search base algorithm.
     * Decodes your encoded data to tree.
     *
     * @time-complexity - O (logn).
     * @space-complexity - O (1).
     */
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        return dfsDeserialize(dataArray, new int[] {0});
    }

    private TreeNode dfsDeserialize(String[] dataArray, int[] index) {
        if (index[0] >= dataArray.length || dataArray[index[0]].equals("*")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(dataArray[index[0]++]));
        node.left = dfsDeserialize(dataArray, index);
        node.right = dfsDeserialize(dataArray, index);

        return node;
    }
}
