package asu.edu.Arav.ImpG;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		int m = matrix.length;
		if(m == 0) {
			return result;
		}
		int n = matrix[0].length;
		int r = 0, c = 0;
		while (r < m && c < n) {
			for (int i = c; i < n; i++) {
				result.add(matrix[r][i]);
			}
			r++;
			for (int i = r; i < m; i++) {
				result.add(matrix[i][n - 1]);
			}
			n--;
			if (r < m) {
				for (int i = n - 1; i >= c; i--) {
					result.add(matrix[m - 1][i]);
				}
				m--;
			}
			if (c < n) {
				for (int i = m - 1; i >= r; i--) {
					result.add(matrix[i][c]);
				}
				c++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] board = new int[3][4];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = i + j;
			}
		}
		
		System.out.println(spiralOrder(board));
	}
}
