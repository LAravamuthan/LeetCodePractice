package asu.edu.arav.prep.gayle.string.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class ContainsDuplicateInArray {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> intStore = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(intStore.contains(nums[i])){
                return true;
            }
            intStore.add(nums[i]);
        }
        return false;
    }
}
