package asu.edu.arav.ImpG;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public static List<String> result = new ArrayList<String>();
	public static List<String> generateParenthesis(int n) {
		result.clear();
		List<String> result1 = new ArrayList<String>();
		char[] stringArr = new char[n*2];  
		recursiveString(stringArr, n, 0, 0, 0);
		result1 = result;
		return result1;
	}
	
	public static void recursiveString(char[] s, int n, int pos, int f, int b) {
		if(b == n) {
			result.add(new String(s));
		}
		if(f > b){
			s[pos] = ')';
			recursiveString(s, n, pos+1, f, b+1);
		}
		if(f < n) {
			s[pos] = '(';
			recursiveString(s, n, pos+1, f+1, b);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(1));
	}
}
