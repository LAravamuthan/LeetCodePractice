package asu.edu.AravL.easy;

/*Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/

public class ReverseIntegerProblem {
	
	public static void main(String [] args) {
		System.out.println(reverse(-12832));
	}

	public static int reverse(int x) {
		boolean isNegative = (x>0)? false:true;
		StringBuilder stringBuilder = new StringBuilder(Integer.toString(Math.abs(x)));
		stringBuilder.reverse();
		stringBuilder = (isNegative)? stringBuilder.insert(0, "-"):stringBuilder;
		int resultInt = 0;
		try {
			resultInt = Integer.parseInt(stringBuilder.toString());
		}catch(Exception e) {
			return 0;
		}
		return resultInt;
	}
}
