package asu.edu.Arav.ImpG;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class FindPeakInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int first = 0;
        int last = A.length - 1;
        while(first < last){
            int mid = (first + last)/2;
            if(A[mid-1] < A[mid] &&  A[mid] > A[mid+1]){
                return mid;
            }
            else if(A[mid-1] < A[mid]){
                first = mid;
            }else{
                last = mid;
            }
        }
        return -1;
    }
}
