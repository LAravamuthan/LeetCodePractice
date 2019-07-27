package asu.edu.Arav.ImpFaceBook;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class RoatedSortedArraySearch {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (target == nums[0]) {
                return 0;
            } else
                return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;


        while (low < high) {
            if (low + 1 == high) {
                if (target == nums[low]) {
                    return low;
                } else if (target == nums[high]) {
                    return high;
                } else {
                    return -1;
                }
            }
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                if (target == nums[low]) {
                    return low;
                } else if (target < nums[low]) {
                    if (nums[low] < nums[mid]) {
                        if (target > nums[high]) {
                            return -1;
                        } else if (target == nums[high]) {
                            return high;
                        } else {
                            low = mid;
                            mid = (low + high) / 2;
                            continue;
                        }
                    } else if (nums[low] > nums[mid]) {
                        high = mid;
                        mid = (high + low) / 2;
                        continue;
                    }
                } else {
                    high = mid;
                    mid = (low + high) / 2;
                    continue;
                }
            } else if (target > nums[mid]) {
                if (target == nums[high]) {
                    return high;
                } else if (target > nums[high]) {
                    if (nums[mid] < nums[high]) {
                        if (target < nums[low]) {
                            return -1;
                        } else if (target == nums[low]) {
                            return low;
                        } else {
                            high = mid;
                            mid = (low + high) / 2;
                            continue;
                        }
                    } else if (nums[mid] > nums[high]) {
                        low = mid;
                        mid = (high + low) / 2;
                        continue;
                    }
                } else {
                    low = mid;
                    mid = (high + low) / 2;
                    continue;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        search(new int[]{4,5,6,7,0,1,2}, 1);
    }


}
