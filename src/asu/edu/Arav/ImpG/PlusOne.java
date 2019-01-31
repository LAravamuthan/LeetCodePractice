package asu.edu.Arav.ImpG;

public class PlusOne {

	public int[] plusOne(int[] digits) {
		boolean isMore = false;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i]++;
			if (digits[i] > 9) {
				digits[i] %= 10;
			} else {
				break;
			}
			if (i == 0) {
				isMore = true;
			}
		}
		int[] result;
		if (isMore) {
			result = new int[digits.length + 1];
			result[0] = 1;
			System.arraycopy(digits, 0, result, 1, digits.length);
			return result;
		}
		result = digits;
		return result;
	}
}
