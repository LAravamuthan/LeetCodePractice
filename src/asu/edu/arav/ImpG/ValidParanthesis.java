package asu.edu.arav.ImpG;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
	public static boolean isValid(String s) {
		Map<Character, Character> charMap = new HashMap<Character, Character>();
		charMap.put(')', '(');
		charMap.put('}', '{');
		charMap.put(']', '[');
		char[] charArray =  s.toCharArray();
		Stack<Character> s1 = new Stack<Character>();
		for(char c : charArray) {
			if(charMap.containsKey(c)) {
				if(!s1.isEmpty()) {
					if(!s1.pop().equals(charMap.get(c))) {
						return false;
					}
				}
				else {
					return false;
				}
			}
			else {
				s1.push(c);
			}
		}
		if(s1.isEmpty()) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		System.out.println(isValid("([)]"));
	}
}
