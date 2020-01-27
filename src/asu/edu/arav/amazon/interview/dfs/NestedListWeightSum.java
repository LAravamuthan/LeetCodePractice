package asu.edu.arav.amazon.interview.dfs;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/nested-list-weight-sum/
 */


import asu.edu.aravl.utility.MetaUtil.NestedInteger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 */
public class NestedListWeightSum {

    /**
     * @algo - dfs
     * @time-complexity - O(n)
     * @space-complexity - O(1)
     */
    int ans = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        dfsStyleSumming(nestedList, 1);
        return ans;
    }

    public void dfsStyleSumming(List<NestedInteger> nestedList, int depth) {

        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                ans += depth * ni.getInteger();
            } else {
                dfsStyleSumming(ni.getList(), depth + 1);
            }
        }
    }
}
