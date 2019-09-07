package asu.edu.aravl.medium;

import java.util.HashMap;
import java.util.Map;

/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*
*/

public class IntegerToRoman {

	public static int[] romanNumbers = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	public static String[] romanLiterals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	
	public static Map<Character, Integer> literalNumberMap = new HashMap<Character, Integer>();
	
	static {
		literalNumberMap.put('M', 1000);
		literalNumberMap.put('D', 500);
		literalNumberMap.put('C',100);
		literalNumberMap.put('L', 50);
		literalNumberMap.put('X', 10);
		literalNumberMap.put('V', 5);
		literalNumberMap.put('I', 1);
	}

	
	public static void main(String[] args) {
		
		System.out.println(intToRoman(1994));

	}

	public static String intToRoman(int num) {

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < romanNumbers.length; i++) {
			int matches = num / romanNumbers[i];
			repeat(result, romanLiterals[i], matches);
			num = num % romanNumbers[i];
		}
		
		return result.toString();

	}
	
	public static int romanToInt(String s) {
		int sum = 0;
		int pre = 0;
		for(int i = s.length() - 1; i > -1; i--) {
			int digitSum = literalNumberMap.get(s.charAt(i));
			if(digitSum > pre) {
				sum = sum + digitSum;
			}else {
				sum = sum - digitSum;
			}
			pre = digitSum;
		}
		return sum;
	}

	public static StringBuilder repeat(StringBuilder s, String str, int n) {
		for (int i = 0; i < n; i++) {
			s.append(str);
		}
		return s;
	}

}