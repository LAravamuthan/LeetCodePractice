package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LeafSimilarTrees {

    /**
     * DFS approach.
     *
     * @time-complexity - O (N + M), number of nodes in the tree.
     * @space-complexity - O (h(root1) + h(root2)).
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        dfsAddLeaf(root1, leaves1);
        dfsAddLeaf(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void dfsAddLeaf(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) list.add(node.val);
        dfsAddLeaf(node.left, list);
        dfsAddLeaf(node.right, list);
    }


}
