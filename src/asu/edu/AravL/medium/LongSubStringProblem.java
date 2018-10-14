package asu.edu.AravL.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Given a string, find the length of the longest substring without repeating characters.

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
}
