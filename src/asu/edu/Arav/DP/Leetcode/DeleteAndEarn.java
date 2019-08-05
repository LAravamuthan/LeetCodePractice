package asu.edu.Arav.DP.Leetcode;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class DeleteAndEarn {
    public int deleteAndEarnWrong(int[] nums) {

        ConcurrentHashMap<HashSet<Integer>, Integer> setToMaxMap = new ConcurrentHashMap<HashSet<Integer>, Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            boolean isPlaced = false;

            for (HashSet<Integer> set : setToMaxMap.keySet()) {
                if (set.contains(nums[i] + 1) || set.contains(nums[i] - 1)) {
                    continue;
                } else {
                    int valueOfSet = setToMaxMap.get(set);
                    valueOfSet += nums[i];
                    if (valueOfSet > max) {
                        max = valueOfSet;
                    }
                    setToMaxMap.remove(set);
                    set.add(nums[i]);
                    setToMaxMap.put(set, valueOfSet);
                    isPlaced = true;
                }
            }
            if (!isPlaced) {
                if (nums[i] > max) {
                    max = nums[i];
                }
                HashSet<Integer> tmpSet = new HashSet<Integer>();
                tmpSet.add(nums[i]);
                setToMaxMap.put(tmpSet, nums[i]);
                isPlaced = true;
            }
        }
        return max;
    }

    public int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxDigit = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxDigit) {
                maxDigit = nums[i];
            }
        }
        int[] countsOfNums = new int[maxDigit + 1];
        for (int i = 0; i < nums.length; i++) {
            countsOfNums[nums[i]]++;
        }
        int include = 0;
        int skip = 0;

        for (int i = 0; i < countsOfNums.length; i++) {
            if (countsOfNums[i] > 0) {
                int intermediateMax = Math.max(include, skip);
                if (i > 0 && countsOfNums[i - 1] > 0) {
                    include = countsOfNums[i] * i + skip;
                    skip = intermediateMax;
                } else {
                    include = countsOfNums[i] * i + intermediateMax;
                    skip = intermediateMax;
                }
            }
        }
        return Math.max(include, skip);
    }

}
