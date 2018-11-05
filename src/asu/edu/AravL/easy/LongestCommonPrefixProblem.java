package asu.edu.AravL.easy;

/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.*/

public class LongestCommonPrefixProblem {
	public static void main(String[] args) {
		String [] a = {"dog","racecar","car"};
		System.out.println(longestCommonPrefix(a));
	}

	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		boolean toBreak = false;
		int idx = 0;
		while (!toBreak) {
			Character toTest=null;
			for (int i = 0; i < strs.length; i++) {
				if(idx > strs[i].length()) {
					toBreak = true;
					break;
				}
				if(i==0) {
					toTest=strs[i].charAt(idx);
				}
				if(toTest != strs[i].charAt(idx)) {
					toBreak = true;
					break;
				}
			}
			if(!toBreak) {
				result.append(toTest);
				idx++;
			}
		}
		return result.toString();
	}
}
