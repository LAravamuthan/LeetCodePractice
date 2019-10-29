package asu.edu.aravl.easy;

import asu.edu.aravl.utility.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class CousinsinBinaryTree {

    static Map<Integer, Integer> depth = new HashMap<>();
    static Map<Integer, TreeNode> valToParent = new HashMap<>();

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        findDepthAndParentUsingDFS(root, null);
        return (depth.get(x) == depth.get(y)) && (valToParent.get(x) != valToParent.get(y));
    }

    public static void findDepthAndParentUsingDFS(TreeNode node, TreeNode parent) {
        depth.put(node.val, parent != null ? 1 + depth.get(parent.val) : 0);
        valToParent.put(node.val, parent);
        if (node.left != null) {
            findDepthAndParentUsingDFS(node.left, node);
        }
        if (node.right != null) {
            findDepthAndParentUsingDFS(node.right, node);
        }
    }

    public static void main(String [] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(isCousins(root, 4, 3));
    }
}
