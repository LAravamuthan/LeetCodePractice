package asu.edu.arav.impgoogle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class SubArraySum {

    /*first Method will be the brute force one. Time complexity - O(n3) and Space Complexity O(1)
     * The algo will be explained later*/
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                int sum = 0;
                for (int l = i; l < j; l++) {
                    sum+=nums[l];
                }
                if(k == sum){
                    count++;
                }
            }
        }
        return count;
    }

    /* first Method will be the HashMap Time complexity - O(n) and Space Complexity O(n)
     * The algo will be explained later */

    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        int sum = 0;
        sumMap.put(sum, 1);

        for(int i=0; i < nums.length; i++){
            sum+=nums[i];
            if(sumMap.containsKey(sum-k)){
                count+=sumMap.get(sum-k);
            }
            sumMap.put(sum,sumMap.getOrDefault(sum, 0)+1);
        }
        return count;
    }


    /* first Method will be the Cumulative Sum Time complexity - O(n2) and Space Complexity O(n)
     * The algo will be explained later */

    public static int subarraySum3(int[] nums, int k) {
        return 0;
    }

    /* first Method will be the Cumulative Sum Time complexity - O(n2) and Space Complexity O(1)
     * The algo will be explained later */

    public static int subarraySum4(int[] nums, int k) {
        return 0;
    }

    public static void main(String[] args){
        int[] listofint = {1,1,1};
        subarraySum2(listofint, 2);
    }
}
