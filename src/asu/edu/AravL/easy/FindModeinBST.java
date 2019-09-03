package asu.edu.AravL.easy;

import asu.edu.AravL.utility.TreeNode;
import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class FindModeinBST {
    private int count = 1;
    private int prevNodeValue = Integer.MIN_VALUE;
    private int maxCount = 0;


    public int[] findMode(TreeNode root) {
        List<Integer> resList = new ArrayList<Integer>();
        recursionBST(root, resList);
        int[] resArray = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArray[i] = resList.get(i);
        }
        return resArray;
    }

    public void recursionBST(TreeNode node, List<Integer> resList) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            recursionBST(node.left, resList);
        }
        if (node.val == prevNodeValue) {
            count++;
        } else {
            count = 1;
        }
        if (maxCount < count) {
            maxCount = count;
            resList.clear();
            resList.add(node.val);
        } else if (maxCount == count) {
            resList.add(node.val);
        }
        prevNodeValue = node.val;
        if (node.right != null) {
            recursionBST(node.right, resList);
        }
    }
}
