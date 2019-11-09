package asu.edu.arav.amazon.interview.bitmanipulation;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;
        for(int n : nums){

            seenOnce = ~seenTwice & (seenOnce^n);
            seenTwice = ~seenOnce & (seenTwice^n);
        }
        return seenOnce;
    }
}
