package asu.edu.arav.ImpG;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int first = 0;
        int last = nums.length-1;

        while(first<last){
            int mid = (first+last)/2;
            if(nums[mid] > nums[mid+1]){
                last = mid;
            }else{
                first = mid +1;
            }
        }
        return first;
    }
}
