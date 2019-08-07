package asu.edu.Arav.ImpFaceBook;

public class MoreZeros {
    public void moveZeroes(int[] nums) {
        int lastZeroDigit = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(lastZeroDigit == -1 && nums[i] == 0){
                lastZeroDigit = i;
                count++;
            }else if(nums[i] == 0){
                count++;
            }else{
                int tmp = nums[i];
                nums[i] = nums[i-count];
                nums[i-count] = tmp;
                lastZeroDigit++;
            }
        }
    }
}
