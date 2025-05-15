package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MedianofTwoSortedArrays {

    /**
     * Find median using normal access technique, easier to conceptualize and wont be easy to implement.
     *
     * @time-complexity - O (n + m).
     * @space-complexity - O (1).
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        p1 = 0;
        p2 = 0;
        int firstMedian = 0;
        for (int i = 0; i < (m + n) / 2; i++) {
            firstMedian = getMin(nums1, nums2);
        }

        return (m + n) % 2 == 0 ? (double)  (firstMedian +  getMin(nums1, nums2))/ 2  : getMin(nums1, nums2);

    }

    private int p1;
    private int p2;

    private int getMin(int[] nums1, int[] nums2) {
        if (p1 < nums1.length && p2 < nums2.length) {
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        else if (p1 < nums1.length) return nums1[p1++];
        else if (p2 < nums2.length) return nums2[p2++];

        return -1;
    }


    public static void main (String [] args) {
        MedianofTwoSortedArrays msf = new MedianofTwoSortedArrays();
        double median = msf.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4});
    }


    /**
     * Find median using normal access technique, easier to conceptualize and wont be easy to implement.
     *
     * @time-complexity - O(Log(min(n,m))).
     * @space-complexity - O (1).
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays2(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int total = m + n;
        int half = (m + n) / 2;
        int l = 0, r = m - 1;
        while (true) {
            int mid = l + (r - l)/2;

            int aLeft = mid >= 0 ? nums1[mid] : Integer.MIN_VALUE;
            int bLeft = half - mid - 2 >= 0 ? nums2[half - mid - 2] : Integer.MIN_VALUE;
            int aRight = mid + 1 < m ? nums1[mid + 1] : Integer.MAX_VALUE;
            int bRight = half - mid - 1 < n ? nums2[half - mid - 1] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 == 0) return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                else return Math.min(aRight, bRight);
            }

            if (aLeft > bRight) r = mid - 1;
            else l = mid + 1;

        }
    }


    /**
     * Find median using normal access technique, easier to conceptualize and wont be easy to implement.
     * Practice.
     * TODO: Binary search variation.
     *
     * @time-complexity - O(Log(min(n,m))).
     * @space-complexity - O (1).
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays3(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int half = (m + n) / 2;
        int l = 0, r = m;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int aLeft = mid - 1 >= 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int bLeft = half - mid - 1 >= 0 ? nums2[half - mid - 1] : Integer.MIN_VALUE;
            int aRight = mid < m ? nums1[mid] : Integer.MAX_VALUE;
            int bRight = half - mid < n ? nums2[half - mid] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if ((m + n) % 2 == 0) return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                return Math.min(aRight, bRight);
            }

            if (aLeft > bRight) r = mid - 1;
            else l = mid + 1;
        }

        return -1;
    }
}
