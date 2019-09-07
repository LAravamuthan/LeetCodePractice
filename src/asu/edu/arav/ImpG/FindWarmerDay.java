package asu.edu.arav.ImpG;

import java.util.Stack;

public class FindWarmerDay {

	public static int[] dailyTemperatures(int[] T) {
		int[] ans = new int[T.length]; // ans list
		Stack<Integer> s = new Stack<Integer>(); // to check the most near warmer day
		for (int i = T.length - 1; i >= 0; i--) {
			/*
			 * below while loop find the recent future index when the temperature was higher
			 * then the temperature at the current the index This also removes the
			 * temperature lower than the current temperature as those are not important
			 * anymore as the current temperature will be the most recent compared to others
			 */
			while (!s.isEmpty() && T[s.peek()] <= T[i])
				s.pop();
			ans[i] = s.isEmpty() ? 0 : s.peek() - i;// if the stack goes empty than temperature is more than current
													// temperature
			s.push(i);// make the index of current temperature most recent
		}
		return ans;
	}
	
	public static int[] dailyTemperatures2(int[] T) {
		int[] ans = new int[T.length]; // ans list
		int[] meta = new int[T.length]; // used to know the index which has been not set
		int top = -1;
		for (int i = 0; i < T.length; i++) {
			/*
			 * below while loop searches for indexes which have not been set values using the
			 * temperature refered by the current index 
			 * 
			 */
			while (top > -1 && T[i] > T[meta[top]]) {
				/*all those temperatures which are lesser than current temperature will get 
				 * an value if not set already*/
				ans[meta[top]] = i - meta[top];
				top--;
			}
			meta[++top] = i;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] T = {73,74,75,71,69,72,76,73};
		System.out.println(dailyTemperatures2(T));
	}

}
