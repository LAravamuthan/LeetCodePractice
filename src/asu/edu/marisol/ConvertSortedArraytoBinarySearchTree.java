package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ConvertSortedArraytoBinarySearchTree {

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
     * Recursion and binary search concept
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h).
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return createNode(nums, 0, nums.length - 1);
    }

    private TreeNode createNode(int [] nums, int l, int r) {
        if (l > r) return null;
        int mid = (r - l) / 2 + l;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createNode(nums, l, mid - 1);
        node.right = createNode(nums, mid + 1, r);
        return node;
    }
}
