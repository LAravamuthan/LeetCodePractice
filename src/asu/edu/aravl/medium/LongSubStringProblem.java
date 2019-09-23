package asu.edu.aravl.medium;

import java.util.HashMap;
import java.util.Map;

/*Given a string, find the length of the longest substring without repeating characters.

https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2961/
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class LongSubStringProblem {
	
	public int lengthOfLongestSubstring(String s) {
		char[] charset = s.toCharArray();
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		int resultLength=0;
		int tempResultLength=0;
		for(int i = 0; i < charset.length; i++) {
			if((charMap.get(charset[i])!=null) && ((i-charMap.get(charset[i])) <= tempResultLength)) {
				tempResultLength = (i-charMap.get(charset[i]));
			}else{
                ++tempResultLength;
            }
            if((charset.length-i-1 + tempResultLength) < resultLength) {
				break;
			}
			charMap.put(charset[i], i);
			resultLength = tempResultLength > resultLength? tempResultLength: resultLength;
		}
		return resultLength;
	}

	public int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int ans = 0, res = 0;

		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (charMap.containsKey(s.charAt(i)) && i - charMap.get(s.charAt(i)) <= ans) {
				ans = i - charMap.get(s.charAt(i));
			} else {
				ans++;
			}
			if (s.length() - i - 1 + ans < res) {
				return res;
			}
			charMap.put(s.charAt(i), i);
			res = Math.max(res, ans);
		}
		return res;
	}
}
