package asu.edu.marisol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class AllNodesDistanceKinBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * My approach did not work will work with the logic of building graph and doing dfs.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N).
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.ans = new ArrayList<>();
        this.graphMap = new HashMap<>();
        this.k = k;

        buildGraph(root, null);
        visited.add(target.val);
        dfs(target.val, 0);

        return ans;
    }

    private List<Integer> ans;
    private int k;
    private Map<Integer, List<Integer>> graphMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    private void buildGraph(TreeNode node, TreeNode parent) {
        if (node != null && parent != null) {
            this.graphMap.computeIfAbsent(node.val, k -> new ArrayList<>()).add(parent.val);
            this.graphMap.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(node.val);
        }

        if (node.left != null) {
            buildGraph(node.left, node);
        }

        if (node.right != null) {
            buildGraph(node.right, node);
        }
    }

    private void dfs(Integer node, int distance) {
        if (distance == k) {
            ans.add(node);
            return;
        }
        for (int neighbor : graphMap.getOrDefault(node, new ArrayList<>())) {
            if (!(visited.contains(neighbor))) {
                visited.add(neighbor);
                dfs(neighbor, distance + 1);
            }
        }
    }

    /**
     * Not building explicit graph, but implicitly using parentMap.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(N).
     */
    public List<Integer> distanceK2(TreeNode root, TreeNode target, int k) {
        this.answer = new ArrayList<>();
        this.parentMap = new HashMap<>();
        this.visitedNode = new HashSet<>();
        addParent(root, null);
        dfsSearch(target, k);

        return answer;
    }

    private void addParent(TreeNode node, TreeNode parentNode) {

        parentMap.put(node, parentNode);
        if (node.left != null) addParent(node.left, node);
        if (node.right != null) addParent(node.right, node);

    }

    List<Integer> answer;
    private Map<TreeNode, TreeNode> parentMap;
    private Set<TreeNode> visitedNode;

    private void dfsSearch(TreeNode node, int distance) {
        if (node == null || visitedNode.contains(node)) return;

        visitedNode.add(node);
        if (distance == 0) {
            answer.add(node.val);
            return;
        }


        dfsSearch(parentMap.get(node), distance - 1);
        dfsSearch(node.left, distance - 1);
        dfsSearch(node.right, distance - 1);

    }
}
