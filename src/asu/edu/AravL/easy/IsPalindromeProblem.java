package asu.edu.AravL.easy;

import java.util.ArrayList;
import java.util.List;

/*Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?*/

public class IsPalindromeProblem {
	
	public static void main(String [] args) {
		System.out.println(isPalindrome(1001));
	}

	public static boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}
		List<Integer> tempList = new ArrayList<Integer>();
		int m = x;
		while(m!=0) {
			int reminder = m % 10;
			m=m/10;
			tempList.add(reminder);
		}
		int size = tempList.size();
		for(int i = 0; i < (size/2); i++ ) {
			if(tempList.get(i) != tempList.get(size-i-1)) {
				return false;
			}
		}
		return true;
	}

}
