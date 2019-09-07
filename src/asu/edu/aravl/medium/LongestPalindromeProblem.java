package asu.edu.aravl.medium;

import java.util.Arrays;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

public class LongestPalindromeProblem {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aaaa"));
	}

	public static String longestPalindrome(String s) {
		int maxSize = 1;
		int[] resultIdxs = new int[2];
		char[] inputChars = s.toCharArray();
		if (inputChars.length == 0) {
			return "";
		}
		int k = 0;
		boolean inPattern = false;

		for (int i = 1; i < inputChars.length; i++) {

			if (inputChars[k] == inputChars[i] && (i - k) < 3) {
				inPattern = true;
			} else if (k != 0 && inputChars[k - 1] == inputChars[i]) {
				k = k - 1;
				inPattern = true;
			} else if ((i > 1) && (inputChars[i - 1] == inputChars[i] || inputChars[i - 2] == inputChars[i])) {
				if (inputChars[i - 1] == inputChars[i]) {
					k = i - 1;
				} else if (inputChars[i - 2] == inputChars[i]) {
					k = i - 2;
				}
				inPattern = true;
			} else {
				inPattern = false;
				k = i;
			}

			if (inPattern) {
				if (inputChars[k] != inputChars[i]) {
					inPattern = false;
				}
			}

			if (!inPattern && k != 0 && inputChars[k - 1] == inputChars[i]) {
				k = k - 1;
				inPattern = true;
			} /*
				 * else if (!inPattern) { k = i + 1; }
				 */
			if (i > k) {
				if (maxSize < i - k + 1) {
					maxSize = i - k + 1;
					resultIdxs[0] = k;
					resultIdxs[1] = i;
				}
			}
		}
		if (maxSize > 1) {
			return s.substring(resultIdxs[0], resultIdxs[1] + 1);
		}
		return "" + inputChars[0];
	}
	
	public int longestPalindromicSubstringLinear(char input[]) {
        int index = 0;
        char newInput[] = new char[2*input.length + 1];
        for(int i=0; i < newInput.length; i++) {
            if(i % 2 != 0) {
                newInput[i] = input[index++];
            } else {
                newInput[i] = '$';
            }
        }
        int T[] = new int[newInput.length];
        int start = 0;
        int end = 0;
        for(int i=0; i < newInput.length; ) {
            while(start >0 && end < newInput.length-1 && newInput[start-1] == newInput[end+1]) {
                start--;
                end++;
            }
            T[i] = end - start + 1;

            if(end == T.length -1) {
                break;
            }
           int newCenter = end + (i%2 ==0 ? 1 : 0);
            for(int j = i + 1; j <= end; j++) {

                T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
                if(j + T[i - (j - i)]/2 == end) {
                    newCenter = j;
                    break;
                }
            }
            i = newCenter;
            end = i + T[i]/2;
            start = i - T[i]/2;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < T.length; i++) {
            int val;
            val = T[i]/2;
            if(max < val) {
                max = val;
            }
        }
        return max;
    }
	
	
	public static String findLongestPalindrome(String s) {
        if (s==null || s.length()==0)
            return "";
        
        char[] s2 = aBoundaries(s.toCharArray());
        int[] p = new int[s2.length]; 
        int c = 0, r = 0; 
        int m = 0, n = 0;
        for (int i = 1; i<s2.length; i++) {
            if (i>r) {
                p[i] = 0; m = i-1; n = i+1;
            } else {
                int i2 = c*2-i;
                if (p[i2]<(r-i-1)) {
                    p[i] = p[i2];
                    m = -1;
                } else {
                    p[i] = r-i;
                    n = r+1; m = i*2-n;
                }
            }
            while (m>=0 && n<s2.length && s2[m]==s2[n]) {
                p[i]++; m--; n++;
            }
            if ((i+p[i])>r) {
                c = i; r = i+p[i];
            }
        }
        int len = 0; c = 0;
        for (int i = 1; i<s2.length; i++) {
            if (len<p[i]) {
                len = p[i]; c = i;
            }
        }
        char[] ss = Arrays.copyOfRange(s2, c-len, c+len+1);
        return String.valueOf(rBoundaries(ss));
    }
 
    private static char[] aBoundaries(char[] cs) {
        if (cs==null || cs.length==0)
            return "||".toCharArray();

        char[] cs2 = new char[cs.length*2+1];
        for (int i = 0; i<(cs2.length-1); i = i+2) {
            cs2[i] = '|';
            cs2[i+1] = cs[i/2];
        }
        cs2[cs2.length-1] = '|';
        return cs2;
    }

    private static char[] rBoundaries(char[] cs) {
        if (cs==null || cs.length<3)
            return "".toCharArray();

        char[] cs2 = new char[(cs.length-1)/2];
        for (int i = 0; i<cs2.length; i++) {
            cs2[i] = cs[i*2+1];
        }
        return cs2;
    }


}
