package asu.edu.arav.amazon.interview.dfs;

import asu.edu.aravl.utility.MetaUtil.NestedInteger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/nested-list-weight-sum-ii/
 */
public class NestedListWeightSumII {

    /**
     * @algo - dfs
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */

    Map<Integer, Integer> levelToSumMap = new HashMap<Integer, Integer>();
    int maxLevel = Integer.MIN_VALUE;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        dfsStyleSumming(nestedList, 0);
        int ans = 0;
        for (int level : levelToSumMap.keySet()) {
            ans += (maxLevel - level) * levelToSumMap.get(level);
        }
        return ans;
    }

    public void dfsStyleSumming(List<NestedInteger> nestedList, int depth) {
        if (depth + 1 > maxLevel) {
            maxLevel = depth + 1;
        }
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                levelToSumMap.put(depth, levelToSumMap.getOrDefault(depth, 0) + ni.getInteger());
            } else {
                dfsStyleSumming(ni.getList(), depth + 1);
            }
        }
    }

}
