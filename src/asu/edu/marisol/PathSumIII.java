package asu.edu.marisol;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class PathSumIII {

    /**
     * Path sum with certain twist.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (h) -> height of the tree, can be 'n' in worst case.
     */
    public int pathSum(TreeNode root, int targetSum) {
        this.count = 0;
        this.map = new HashMap<>();
        this.targetSum = targetSum;
        dfs(root, 0l);
        return count;
    }

    private int count;
    private Map<Long, Integer> map;
    private int targetSum;

    private void dfs(TreeNode node, long runningSum) {
        if (node == null) return;
        if (runningSum + node.val == targetSum)
            count++;
        if (map.containsKey(runningSum + node.val - targetSum))
            count += map.get(runningSum + node.val - targetSum);
        map.put(runningSum + node.val, map.getOrDefault(runningSum + node.val, 0) + 1);
        dfs(node.left,runningSum + node.val);
        dfs(node.right,runningSum + node.val);
        map.put(runningSum + node.val, map.getOrDefault(runningSum + node.val, 0) - 1);
    }

}
