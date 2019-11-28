package asu.edu.arav.amazon.interview.dfs;

import asu.edu.aravl.utility.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class PathSumIII {
    // this problem has two types of solution , one naive exponential
    // but idea is cool
    // next one would be efficient but uses backtracking, lets try both
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // the below statement is the most tricky one
        // first one is normal dfs and the next two are new searches in
        // the left and right sub tree cool right
        // really awesome
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    // below method is standard it proper dfs search for the sum including every
    // node value

    public int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // if current root makes the sum then add it to total +  no. of left subtree
        // paths with current root.val + no. of right subtree paths with current root.val
        return (root.val == sum ? 1 : 0) + dfs(root.left, sum - root.val) +
                dfs(root.right, sum - root.val);
    }

    // lets try the backtracking approach
    // this is awesome again
    public int pathSum1(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        // this hashMap key - sum and value - the number of sums
        Map<Integer, Integer> sumsInCurrent = new HashMap<>();
        // zero sum has count 1 of course
        sumsInCurrent.put(0,1);
        // start testing from root
        return brackTrack(root, 0, sum, sumsInCurrent);
    }

    public int brackTrack(TreeNode root, int currSum, int sum, Map<Integer, Integer> hm){
        if(root == null){
            return 0;
        }
        int paths = 0;
        // current value which is its active ancestors sum plus itself
        currSum+= root.val;
        // this will calculate the no. paths with sum == sum
        // this works because it find  all active prefix sum count in the
        // current path without which present sum can be achived
        paths +=  hm.getOrDefault(currSum - sum, 0);
        // put present contribution in the hashmap
        // this can used by its child to get the target sum
        // really cool logic this entry makes sure
        // that a sum can be made after the present node
        hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);
        // do the same left and right subtree
        paths += brackTrack(root.left, currSum, sum, hm);
        paths += brackTrack(root.right, currSum, sum, hm);
        // this step is also very important one which makes sum of current node
        // plus its ancestors is not used by some other branchs node to form
        // the target sum
        hm.put(currSum, hm.getOrDefault(currSum, 0) - 1);
        return paths;
    }


}
