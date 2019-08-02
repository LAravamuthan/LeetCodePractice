package asu.edu.Arav.ImpFaceBook;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int lastZeroDigit = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(lastZeroDigit == -1 && nums[i] == val){
                lastZeroDigit = i;
                count++;
            }else if(nums[i] == val){
                count++;
            }else{
                int tmp = nums[i];
                nums[i] = nums[i-count];
                nums[i-count] = tmp;
                lastZeroDigit++;
            }
        }
        return nums.length - count;
    }
}
