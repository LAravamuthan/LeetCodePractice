package asu.edu.Arav.ImpG;

import java.util.HashMap;
import java.util.Map;

public class JudgeCircle {
	public static boolean judgeCircle(String moves) {
		int x = 0, y = 0;
		char[] m = moves.toCharArray();
		for (int i = 0; i < m.length; i++) {
			if (m[i] == 'U')
				y++;
			else if (m[i] == 'D')
				y--;
			else if (m[i] == 'R')
				x++;
			else
				x--;
		}
		return x == 0 && y == 0;
	}

	public static void main(String[] args) {

	}
}
