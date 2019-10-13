package asu.edu.arav.amazon.interview.leetcode.module.arraysandstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    // This solutions will contain duplicate triplets too;
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int k = 0;
        Map<Integer, Integer> numCountMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int toBeCheckedInteger = k - nums[i] - nums[j];
                if (numCountMap.containsKey(toBeCheckedInteger)) {
                    if ((toBeCheckedInteger != nums[i] && nums[j] != toBeCheckedInteger)
                            || (toBeCheckedInteger == nums[i] && nums[j] == toBeCheckedInteger && numCountMap.get(toBeCheckedInteger) > 2)
                            || (numCountMap.get(toBeCheckedInteger) > 1)) {
                        List<Integer> a = new ArrayList<Integer>();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(toBeCheckedInteger);
                        ans.add(a);
                    }
                }
            }
        }
        return ans;
    }


    // Lets try one with out duplicates but it will assume that the nums array  has unique elements
    // lets try one more time u see I had eureka moment
    // Awesome they want the simpler so try one more time

    static Map<Integer, Boolean> numBolMap = new HashMap<Integer, Boolean>();
    static Map<Integer, List<Integer>> numUsedIdx = new HashMap<Integer, List<Integer>>();

    public static int findComptableElement(int iIdx, int jIdx, int[] nums, int value) {
        int idxCompare = -1;
        for (int idx : numUsedIdx.get(value)) {
            if (idx != iIdx && idx != jIdx) {
                idxCompare = idx;
            }
        }
        if (idxCompare != -1) {
            if (!(numBolMap.get(iIdx) && numBolMap.get(jIdx) && numBolMap.get(idxCompare))) {
                return idxCompare;
            } else {
                idxCompare = -1;
            }
        }
        return idxCompare;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            List<Integer> a = numUsedIdx.getOrDefault(nums[i], new ArrayList<Integer>());
            a.add(i);
            numUsedIdx.put(nums[i], a);
        }
        for (int i = 0; i < nums.length; i++) {
            numBolMap.put(i, numBolMap.getOrDefault(i, false));
            for (int j = i + 1; j < nums.length; j++) {
                numBolMap.put(j, numBolMap.getOrDefault(j, false));
                int toBeCheckedInteger = k - nums[i] - nums[j];
                if (numUsedIdx.containsKey(toBeCheckedInteger)) {
                    int idxToCompare = findComptableElement(i, j, nums, toBeCheckedInteger);
                    if (idxToCompare != -1) {
                        List<Integer> a = new ArrayList<Integer>();a.add(nums[i]);a.add(nums[j]);a.add(toBeCheckedInteger);
                        ans.add(a);
                        numBolMap.put(j, true);
                        numBolMap.put(i, true);
                        numBolMap.put(idxToCompare, true);
                    }
                }
            }
        }
        return ans;
    }

    // Simpler one
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int k = 0;
        Map<Integer, Boolean> numBolMap = new HashMap<Integer, Boolean>();
        for(int i = 0; i < nums.length; i++){
            numBolMap.put(nums[i], numBolMap.getOrDefault(nums[i], false));
            for(int j = 0; j < nums.length; j++){
                numBolMap.put(nums[j], numBolMap.getOrDefault(nums[j], false));
                int lastElement = k - nums[i] - nums[j];
                if(numBolMap.containsKey(lastElement)){
                    if (!(numBolMap.get(nums[i]) && numBolMap.get(nums[j]) && numBolMap.getOrDefault(lastElement, false))) {
                        List<Integer> a = new ArrayList<Integer>();a.add(nums[i]);a.add(nums[j]);a.add(lastElement);
                        ans.add(a);
                        numBolMap.put(nums[i], true);
                        numBolMap.put(nums[j], true);
                        numBolMap.put(lastElement, true);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        threeSum2(new int[]{-1,0,1,2,-1,-4});
    }
}
