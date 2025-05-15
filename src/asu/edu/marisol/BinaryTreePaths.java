package asu.edu.marisol;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BinaryTreePaths {

    /**
     * Doing with DFS method.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(h). height of the tree.
     */
    public List<String> binaryTreePaths(TreeNode root) {
        this.ans = new ArrayList<>();
        dfs(root, "");
        return ans;
    }

    private List<String> ans;

    private void dfs(TreeNode node, String path) {
        if (node == null) return;

        path += Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            ans.add(path);
            return;
        }
        path += "->";

        dfs(node.left, path);
        dfs(node.right, path);
    }

    /**
     * Doing with BFS now.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(h). height of the tree.
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> ans = new ArrayList<>();
        Queue<Pair<TreeNode, String>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, ""));

        while(!q.isEmpty()) {
            Pair<TreeNode, String> nodePath = q.poll();
            TreeNode node = nodePath.getKey();
            String path = nodePath.getValue();
            path += Integer.toString(node.val);
            if (node.left == null && node.right == null) ans.add(path);
            path += "->";
            if (node.left != null) q.offer(new Pair<>(node.left, path));
            if (node.right != null) q.offer(new Pair<>(node.right, path));
        }

        return ans;
    }

}
