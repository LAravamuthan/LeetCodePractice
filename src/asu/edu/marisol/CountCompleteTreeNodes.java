package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CountCompleteTreeNodes {
    public class TreeNode {
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
     * Lets do the binary search variation, nice logrithmic answer TBH
     *
     * @time-complexity - O (log^2 d).
     * @space-complexity - O (1)
     */
    public int countNodes(TreeNode root) {
        int d = getDepth(root);

        int l = 0, r = (int) Math.pow(2, d) - 1;

        while (l <= r) {
            int pivot = l + (r - l) / 2;
            if(isExists(pivot, d, root)) {
                l = pivot;
            } else {
                r = pivot - 1;
            }
        }

        return (int) Math.pow(2, d) - 1 + l;
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while(node != null) {
            node = node.left;
            depth++;
        }
        return depth;
    }

    private boolean isExists(int idx, int depth, TreeNode node) {
        int l = 0;
        int r = (int) Math.pow(2, depth) - 1;

        for (int i = 0; i < depth; i++) {
            int pivot = l + (r - l) / 2;

            if (idx <= pivot) {
                node = node.left;
                r = pivot;
            } else {
                node = node.right;
                l = pivot + 1;
            }
        }

        return node != null;
    }
}
