package asu.edu.marisol;

import javafx.util.Pair;

import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SumRoottoLeafNumbers {

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
     * Morris tree traversal without any extra space and optimal speed.
     *
     * TODO: Morris Tree traversal needs to be learned as soon as possible.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public int sumNumbers(TreeNode root) {
        int totalSum = 0;
        int curNum = 0;
        while (root != null) {
            if (root.left != null) {
                TreeNode predecessor = root.left;

                int steps = 1;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                    steps++;
                }

                if (predecessor.right == null) {
                    curNum = curNum * 10 + root.val;
                    predecessor.right = root;
                    root = root.left;
                } else {
                    if (predecessor.left == null) {
                        totalSum += curNum;
                    }
                    predecessor.right = null;
                    for (int i = 0; i < steps; i++) {
                        curNum /= 10;
                    }
                    root = root.right;
                }
            } else {
                curNum = curNum * 10 + root.val;
                if (root.right == null) {
                    totalSum += curNum;
                }
                root = root.right;
            }
        }
        return totalSum;
    }

    /**
     * DFS traversal, preorder style using recursion.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(h) -> height of the tree.
     */
    public int sumNumbers2(TreeNode root) {
        if (root == null) return totalLeafSum;
        dfsSumLeaf(root, 0);
        return totalLeafSum;
    }

    private void dfsSumLeaf(TreeNode node, int parentSum) {
        if (node.right == null && node.left == null) {
            totalLeafSum += parentSum * 10 + node.val;
            return;
        }

        if (node.left != null) {
            dfsSumLeaf(node.left, parentSum * 10 + node.val);
        }
        if (node.right != null) {
            dfsSumLeaf(node.right, parentSum * 10 + node.val);
        }
    }

    private int totalLeafSum = 0;


    /**
     * DFS traversal, preorder style iterative method.
     *
     * @time-complexity - O(n).
     * @space-complexity - O(h) -> height of the tree.
     */
    public int sumNumbers3(TreeNode root) {
        if (root == null) return 0;
        int totalSumLeafIterative = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> stackElement = stack.pop();
            TreeNode node = stackElement.getKey();
            int parentValue = stackElement.getValue();

            if (node.right == null && node.left == null) {
                totalSumLeafIterative += parentValue * 10 + node.val;
            }

            if(node.left != null) {
                stack.push(new Pair<>(node.left, parentValue * 10 + node.val));
            }

            if(node.right != null) {
                stack.push(new Pair<>(node.right, parentValue * 10 + node.val));
            }
        }

        return totalSumLeafIterative;
    }



    /**
     * Binary morris traversal.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(1).
     */
    public int sumNumbers4(TreeNode root) {
        int rootToLeaf = 0, curNumber = 0;
        int steps; TreeNode predecessor;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                steps = 1;

                // find the inoder predecessor
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                    steps++;
                }

                // first time the back egde has been made, safely traverse the left subtree
                if (predecessor.right == null) {
                    curNumber = curNumber * 10 + root.val;
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // condition for leaf
                    if (predecessor.left == null) {
                        rootToLeaf += curNumber;
                    }

                    // take back the steps we had to do to get curNumber for the node.
                    for (int i = 0; i < steps; i++) curNumber /= 10;

                    // go to right subtree
                    root = root.right;
                }
            } else {
                curNumber = curNumber * 10 + root.val;
                if (root.right == null) rootToLeaf += curNumber;
                root = root.right;
            }
        }

        return rootToLeaf;
    }

}
