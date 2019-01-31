package asu.edu.Arav.ImpG;

public class NextPermutation {

	public static int binarySearch(int[] a, int x, int s) {
		int low = s;
		int high = a.length - 1;
		int mid;
		while (low < high) {
			mid = (low + high) / 2;
			if (a[mid] <= x) {
				high = mid;
			} else {
				low = mid+1;
			}
		}
		if (a[low] <= x) {
			return low - 1;
		}
		return low;
	}

	public static boolean nextPermutation1(int[] nums) {
		int i = nums.length - 1;
		while (i > 0 && nums[i - 1] >= nums[i]) {
			i--;
		}
		int j = nums.length - 1;
		if (i > 0) {
			j = binarySearch(nums, nums[i - 1], i);
			int temp = nums[i - 1];
			nums[i - 1] = nums[j];
			nums[j] = temp;
		}
		j = nums.length - 1;
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
		for (int i1 : nums) {
			System.out.println(i1);
		}

		return true;
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void reverse(int[] a, int i) {
		int j = a.length - 1;
		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}
	}

	public static void nextPermutation(int[] nums) {

		int j = nums.length - 1;
		while (j > 0 && nums[j] <= nums[j - 1]) {
			j--;
		}
		if (j > 0) {
			int i = nums.length - 1;
			while (i > (j - 1) && nums[(j - 1)] >= nums[i]) {
				i--;
			}
			swap(nums, i, (j - 1));
		}
		reverse(nums, j);
		for (int i : nums) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 2 };
		int[] nums1 = new int[] {2,2,7,5,4,3,2,2,1};
		nextPermutation(nums);
		nextPermutation1(nums1);
	}
}
