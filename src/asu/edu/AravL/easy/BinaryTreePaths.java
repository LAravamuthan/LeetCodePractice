package asu.edu.AravL.easy;

import asu.edu.AravL.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = binaryTreePathsR(root, "");
        return result;
    }

    public List<String> binaryTreePathsR(TreeNode node, String s) {
        if (node == null) {
            return new ArrayList<String>();
        }
        if (node.left == null && node.right == null) {
            if (!s.isEmpty()) {
                s = s + "->" + node.val;
            } else {
                s = "" + node.val;
            }

            List<String> result = new ArrayList<String>();
            result.add(s);
            return result;
        }

        List<String> leftPathList = new ArrayList<String>();
        List<String> rightPathList = new ArrayList<String>();

        if (!s.isEmpty()) {
            s = s + "->" + node.val;
        } else {
            s = "" + node.val;
        }

        if (node.left != null) {
            leftPathList = binaryTreePathsR(node.left, s);
        }
        if (node.right != null) {
            rightPathList = binaryTreePathsR(node.right, s);
        }

        leftPathList.addAll(rightPathList);
        return leftPathList;
    }
}
