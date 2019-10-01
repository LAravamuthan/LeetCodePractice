package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/maximum-average-subtree/
 */
public class MaximumAverageSolution {
    double avgMax = Double.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {
        getSumAndTotal(root);
        return avgMax;
    }

    public Map<String, Double> getSumAndTotal(TreeNode root) {
        if (root == null) {
            return null;
        }
        double sum = root.val;
        double count = 1;

        Map<String, Double> ml = getSumAndTotal(root.left);
        Map<String, Double> mr = getSumAndTotal(root.right);
        if (ml != null) {
            sum += ml.get("sum");
            count += ml.get("count");
        }
        if (mr != null) {
            sum += mr.get("sum");
            count += mr.get("count");
        }
        if (avgMax < (sum / count)) {
            avgMax = sum / count;
        }

        Map<String, Double> m = new HashMap<String, Double>();
        m.put("sum", sum);
        m.put("count", count);
        return m;
    }
}
