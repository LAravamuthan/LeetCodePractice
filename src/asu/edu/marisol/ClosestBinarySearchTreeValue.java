package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ClosestBinarySearchTreeValue {

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
     * DFS approach.
     *
     * @time-complexity - O (N)
     * @space-complexity - O (h).
     */
    public int closestValue(TreeNode root, double target) {
        this.abs = Double.MAX_VALUE;
        this.target = target;
        this.ans = Integer.MAX_VALUE;
        dfs(root);
        return this.ans;
    }

    private double abs;
    private int ans;
    private double target;

    private void dfs(TreeNode node) {
        if (node == null) return;

        if (Math.abs(target - node.val) <= abs) {
            if (Math.abs(target - node.val) == abs) ans = Math.min(ans, node.val);
            else ans = node.val;
            abs = Math.abs(target - node.val);
        }

        if (node.val < target) dfs(node.right);
        else dfs(node.left);
    }

    /**
     * DFS approach, cleaner approach without initial class values.
     *
     * @time-complexity - O (N)
     * @space-complexity - O (h).
     */
    public int closestValue2(TreeNode root, double target) {
        return dfs(root, target, root.val);
    }

    private int dfs(TreeNode node, double target, int closest) {
        if (node == null) return closest;

        double diff = Math.abs(target - node.val);
        double closestDiff = Math.abs(target - closest);

        if (diff < closestDiff) {
            closest = node.val;
        } else if (diff == closestDiff) {
            closest = Math.min(closest, node.val);
        }

        if (node.val < target) return dfs(node.right, target, closest);
        else return dfs(node.left, target, closest);
    }


    /**
     * DFS approach, iterative approach.
     *
     * @time-complexity - O (n)
     * @space-complexity - O (1).
     */
    public int closestValue3(TreeNode root, double target) {
        int closest = root.val;

        while (root != null) {
            double diff = Math.abs(target - root.val);
            double closestDiff = Math.abs(target - closest);

            if (diff < closestDiff) closest = root.val;
            else if (diff == closestDiff) closest = Math.min(closest, root.val);

            root = root.val < target ? root.right : root.left;
        }

        return closest;
    }

}
