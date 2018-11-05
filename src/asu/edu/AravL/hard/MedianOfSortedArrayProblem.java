package asu.edu.AravL.hard;

/*There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.
Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5*/

public class MedianOfSortedArrayProblem {

	public static void main(String[] args) {
		int[] a = new int[2];
		int[] b = new int[2];
		a[0] = 3;
		a[1] = 4;
		b[0] = -2;
		b[1] = -1;
		System.out.println(findMedianSortedArrays1(a, b));
	}

	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {

		int lengthOfresultantList = nums1.length + nums2.length;
		int median = (lengthOfresultantList / 2) - 1;
		int result1 = 0;
		int result2 = 0;
		boolean isResultEven = (lengthOfresultantList % 2) == 0 ? true : false;
		if (nums1.length == 0 && nums2.length == 0) {
			return 0.0;
		}
		if (nums1.length == 0) {
			result1 = result2 = nums2[median + 1];
			if (isResultEven) {
				result2 = nums2[median];
			}
			return (double) (result1 + result2) / 2;
		} else if (nums2.length == 0) {
			result1 = result2 = nums1[median + 1];
			if (isResultEven) {
				result2 = nums1[median];
			}
			return (double) (result1 + result2) / 2;
		}

		int firstLast = nums1.length - 1;
		int secondFirst = 0;
		if (nums1[firstLast] < nums2[secondFirst]) {
			if ((median + 1) > nums1.length - 1) {
				result1 = result2 = nums2[(median + 1) - nums1.length];
			} else {
				result1 = result2 = nums1[(median + 1)];
			}

			if (isResultEven) {
				if ((median) > (nums1.length - 1)) {
					result2 = nums2[median - nums1.length];
				} else {
					result2 = nums1[median];
				}
			}
			return (double) (result1 + result2) / 2;
		}
		int lowerIdx1 = 0;
		int higherIdx1 = nums1.length - 1;
		int lowerIdx2 = 0;
		int higherIdx2 = nums2.length - 1;

		boolean first = true;

		do {
			firstLast = (lowerIdx1 + higherIdx1) / 2;
			secondFirst = (lowerIdx2 + higherIdx2) / 2;
			if (higherIdx1 - lowerIdx1 == 1)
				firstLast = higherIdx1;
			if (higherIdx2 - lowerIdx2 == 1)
				secondFirst = higherIdx2;
			if (nums1[firstLast] > nums2[secondFirst]) {
				lowerIdx1 = firstLast;
				higherIdx2 = secondFirst;
				first = false;
			}
			if (nums1[firstLast] < nums2[secondFirst]) {
				higherIdx1 = firstLast;
				lowerIdx2 = secondFirst;
				first = true;
			}
		} while ((higherIdx1 - lowerIdx1 > 2) || (higherIdx2 - lowerIdx2 > 2));
		int pivot = first ? firstLast : secondFirst;
		if ((median + 1) > pivot) {
			if (first)
				result1 = result2 = nums2[(median + 1) - (pivot + 1)];
			else
				result1 = result2 = nums1[(median + 1) - (pivot + 1)];
		} else {
			if (first)
				result1 = result2 = nums1[(median + 1)];
			else
				result1 = result2 = nums2[(median + 1)];
		}
		if (isResultEven) {
			if ((median) > (pivot)) {
				if (first)
					result2 = nums2[median - (pivot + 1)];
				else
					result2 = nums1[median - (pivot + 1)];
			} else {
				if (first)
					result2 = nums1[median];
				else
					result2 = nums2[median];
			}
		}
		return (double) (result1 + result2) / 2;
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int[] a = nums1;
		int[] b = nums2;

		if (nums1.length > nums2.length) {
			n = nums2.length;
			m = nums1.length;
			a = nums2;
			b = nums1;
		}

		int min_idx = 0, max_idx = n, i = 0, j = 0, median = 0;

		while (min_idx <= max_idx) {
			i = (min_idx + max_idx) / 2;
			j = ((n + m + 1) / 2) - i;
			if (i > 0 && j < m && a[i - 1] > b[j]) {
				max_idx = i - 1;
			} else if (j > 0 && i < n && b[j - 1] > a[i]) {
				min_idx = i + 1;
			} else {
				if (i == 0) {
					median = b[j - 1];
				} else if (j == 0) {
					median = a[i - 1];
				} else {
					median = Math.max(a[i - 1], b[j - 1]);
				}
				break;
			}
		}

		if ((n + m) % 2 == 1) {
			return (double) median;
		}
		if (i == n) {
			return (double) (median + b[j]) / 2;
		}
		if (j == m) {
			return (double) (median + a[i]) / 2;
		}
		return (double) (median + Math.min(a[i], b[j])) / 2;
	}

}
