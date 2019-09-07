package asu.edu.arav.impgoogle;

import java.util.HashSet;
import java.util.Set;

public class LonestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		Set<Integer> s = new HashSet<Integer>();
		for (int i : nums) {
			s.add(i);
		}
		int ans = 0;
		for (int i : nums) {
			if (!s.contains(i - 1)) {
				int tempAns = 1;
				int tempI = i;
				while (s.contains(tempI + 1)) {
					tempI++;
					tempAns++;
				}
				ans = Math.max(tempAns, ans);
			}
		}
		return ans;
	}

	public int longestConsecutive2(int[] nums) {
		Set<Integer> s = new HashSet<Integer>();
		for (int i : nums) {
			s.add(i);
		}
		int ans = 0;
		for (int i : nums) {
			int size = 1;
			int fi = i + 1, bi = i - 1;
			s.remove(i);
			while (s.contains(fi + 1)) {
				s.remove(fi);
				fi++;
				size++;
			}
			while (s.contains(bi - 1)) {
				s.remove(bi);
				bi--;
				size++;
			}
			ans = ans > size ? ans : size;
		}
		return ans;
	}

}
