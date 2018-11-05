package asu.edu.AravL.medium;

import java.util.ArrayList;
import java.util.List;

/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I*/

public class ZigZagConversionProblem {
	
	public static void main(String [] args) {
		System.out.println(convert("PAYPALISHIRING", 4));
	}
	
	
	public static String convert(String s, int numRows) {
		
		List<StringBuilder> resultantList = new ArrayList<StringBuilder>(numRows);
		for(int i = 0; i < numRows; i ++) {
			resultantList.add(new StringBuilder());
		}
		StringBuilder result = new StringBuilder();
		int row = 0;
		boolean down=true;
		if(numRows == 1) {
			return s;
		}
		char [] inputChars = s.toCharArray();
		
		for(int i = 0; i < inputChars.length; i ++) {
			resultantList.get(row).append(inputChars[i]);
			if(down && row!=(numRows-1)) {
				row++;
				continue;
			}
			if(!down && row!=0) {
				row--;
				continue;
			}
			if(row == (numRows-1)) {
				down = false;
				row--;
				continue;
			}
			if(row == 0) {
				down = true;
				row++;
				continue;
			}
		}
		for(StringBuilder sTemp : resultantList) {
			result.append(sTemp);
		}
		return result.toString();
	}
}
