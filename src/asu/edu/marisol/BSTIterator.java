package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class BSTIterator {

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

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        leftInorder(root);
    }

    public int next() {
        TreeNode topNode = stack.pop();
        if (topNode.right != null) {
            leftInorder(topNode.right);
        }
        return topNode.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }

    private void leftInorder(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private List<TreeNode> list;
    private int index = -1;

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        list.add(node);
        inOrder(node.right);

    }

    public void BSTIteratorNew(TreeNode root, Integer i) {
        this.list = new ArrayList<>();
        inOrder(root);
    }

    public int next2() {
        return list.get(++index).val;
    }

    public boolean hasNext2() {
        return index + 1 < list.size();
    }

}
