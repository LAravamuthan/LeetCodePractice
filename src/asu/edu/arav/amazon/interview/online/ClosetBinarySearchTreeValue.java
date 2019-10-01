package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.TreeNode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/closest-binary-search-tree-value/
 */
public class ClosetBinarySearchTreeValue {

    static double  diff = Double.MAX_VALUE;
    static double targetG = 0.0;
    static int answer = -1;

    public static int closestValue(TreeNode root, double target) {
        targetG = target;
        inOrder(root);
        return answer;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        double diffL = Math.abs(targetG - root.val);
        if (diffL < diff) {
            diff = diffL;
            answer = root.val;
        }
        inOrder(root.left);
        inOrder(root.right);
    }

    public static void main(String [] args){
        TreeNode root = new TreeNode(0);
//        root.left = (new TreeNode(2));
//        root.right = (new TreeNode(5));
//        root.left.left = (new TreeNode(1));
//        root.left.right = (new TreeNode(3));
        System.out.println(closestValue(root, 2147483648.0));
    }
}
