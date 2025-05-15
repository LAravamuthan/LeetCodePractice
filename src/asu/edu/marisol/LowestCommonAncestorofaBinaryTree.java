package asu.edu.marisol;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LowestCommonAncestorofaBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    TreeNode lca = null;
    TreeNode p;
    TreeNode q;

    /**
     * Attempting a node search to get the lowest common ancestor.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h) - height of the tree mostly.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return lca;

        this.p = p;
        this.q = q;
        dfsLCASearch(root);
        return lca;
    }

    public boolean dfsLCASearch(TreeNode node) {
        if (node == null) return false;

        int left = dfsLCASearch(node.left) ? 1 : 0;
        int right = dfsLCASearch(node.right) ? 1 : 0;
        int self = node == p || node == q ? 1 : 0;
        int score = left + right + self;
        if (score == 2) {
            lca = node;
        }
        return score > 0;
    }

    /**
     * Attempting a node search to get the lowest common ancestor with similar recursion.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h) - height of the tree mostly.
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        if (p == root || q == root) return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }


    private static int BOTH_PENDING = 2;
    private static int BOTH_DONE = 0;

    /**
     * Attempting a node search to get lowest common ancestor without recursion and no parent pointer, coolio right.
     *
     * @time-complexity - O (H) - without back tracking, once we find the node we return.
     * @space-complexity - O (h) - height of the tree mostly.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        TreeNode parentNode = null;
        TreeNode childNode = null;
        TreeNode LCA = null;
        boolean one_found = false;

        stack.add(new Pair<>(root, BOTH_PENDING));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.peek();
            parentNode = pair.getKey();
            int nodesVisited = pair.getValue();
            if (nodesVisited != BOTH_DONE) {
                if (nodesVisited == BOTH_PENDING) {
                    if (parentNode == p || parentNode == q) {
                        if(one_found) {
                            return LCA;
                        } else {
                            one_found = true;
                            LCA = pair.getKey();
                        }
                    }
                    childNode = parentNode.left;
                } else {
                    childNode = parentNode.right;
                }

                stack.pop();
                stack.add(new Pair<>(pair.getKey(), pair.getValue() - 1));
                if (childNode != null) {
                    stack.add(new Pair<>(childNode, BOTH_PENDING));
                }
            } else {
                if (LCA == stack.pop().getKey()) LCA = stack.peek().getKey();
            }
        }
        return null;
    }


    /**
     * Attempting a node search to get lowest common ancestor without recursion and parent pointer.
     * The approach is to make hashMap parent to child, then trace the family tree of one node and then trace the family
     * tree of other node and the moment we find common ancestor enjoy the answer.
     *
     * @time-complexity - O (H) - without back tracking, once we find the node we return.
     * @space-complexity - O (h) - height of the tree mostly.
     */
    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Set<TreeNode> familySet = new HashSet<>();

        stack.push(root);
        parentMap.put(root, null);

        while (!stack.isEmpty() && (!parentMap.containsKey(p) || !parentMap.containsKey(q))) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }
        }

        while (p != null) {
            familySet.add(p);
            p = parentMap.get(p);
        }

        while (!familySet.contains(q)) {
            q = parentMap.get(q);
        }

        return q;
    }

    /**
     * Attempting a node search to get the lowest common ancestor.
     *
     * Practice of DFS approaches
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h) - height of the tree mostly.
     */
    public TreeNode lowestCommonAncestor5(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return lca;
        this.p = p;
        this.q = q;
        dfs(root);
        return lca;
    }

    private boolean dfs(TreeNode node) {
        if (node == null) return false;

        int left = dfs(node.left) ? 1 : 0;
        int right = dfs(node.right) ? 1 : 0;
        int self = node == p || node == q ? 1 : 0;
        int score = left + right + self;
        if (score > 1) lca = node;
        return score > 0;
    }

    /**
     * Attempting a node search to get the lowest common ancestor.
     * Practice of DFS approaches
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h) - height of the tree mostly.
     */
    public TreeNode lowestCommonAncestor6(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor6(root.left, p, q);
        TreeNode right = lowestCommonAncestor6(root.right, p, q);

        if (left != null && right != null) return root;

        return left != null ? left : right;
    }

    /**
     * Attempting a node search to get lowest common ancestor without recursion and no parent pointer, coolio right.
     *
     * @time-complexity - O (H) - without back tracking, once we find the node we return.
     * @space-complexity - O (h) - height of the tree mostly.
     */
    public TreeNode lowestCommonAncestor7(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        TreeNode child;
        TreeNode lca = null;
        boolean oneFound = false;
        st.push(new Pair<>(root, BOTH_PENDING));

        while(!st.isEmpty()) {
            Pair<TreeNode, Integer> nodePair = st.peek();
            TreeNode node = nodePair.getKey();
            Integer status = nodePair.getValue();

            if (status != BOTH_DONE) {
                if (status == BOTH_PENDING) {
                    if (p == node || q == node) {
                        if (oneFound)
                            return lca;
                        lca = node;
                        oneFound = true;
                    }
                    child = node.left;
                } else {
                    child = node.right;
                }
                st.pop();
                st.push(new Pair<>(node, status - 1));
                if (child != null) st.push(new Pair<>(child, BOTH_PENDING));
            } else {
                if (st.pop().getKey() == lca) lca = st.peek().getKey();
            }
        }

        return null;
    }

    /**
     * Attempting a node search to get lowest common ancestor without recursion and parent pointer.
     * The approach is to make hashMap parent to child, then trace the family tree of one node and then trace the family
     * tree of other node and the moment we find common ancestor enjoy the answer.
     *
     * @time-complexity - O (H) - without back tracking, once we find the node we return.
     * @space-complexity - O (h) - height of the tree mostly.
     */
    public TreeNode lowestCommonAncestor8(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Stack<TreeNode> st = new Stack<>();
        Set<TreeNode> familySet = new HashSet<>();

        st.push(root);
        parentMap.put(root, null);
        while (!st.isEmpty() && (!parentMap.containsKey(p) || !parentMap.containsKey(q))) {
            TreeNode node = st.pop();

            if (node.left != null) {
                parentMap.put(node.left, node);
                st.push(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                st.push(node.right);
            }
        }

        while (p != null) {
            familySet.add(p);
            p = parentMap.get(p);
        }

        while (!familySet.contains(q)) q = parentMap.get(q);

        return q;
    }

}
