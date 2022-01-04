package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2580_스도쿠 {
	static int[][] puzzle;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		puzzle = new int[9][9];
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				puzzle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0, 0);		
	}
	public static void sudoku(int r, int c) {
		if(c == 9) {
			sudoku(r + 1, 0);
			return;
		}
		
		if(r == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(puzzle[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		if(puzzle[r][c] == 0) {
			for(int i = 1; i <= 9; i++) {
				if(possibility(r, c, i)) {
					puzzle[r][c] = i;
					sudoku(r, c + 1);
				}
			}
			puzzle[r][c] = 0;
			return;
		}
		sudoku(r, c + 1);
	}
	public static boolean possibility(int r, int c, int val) {
		for(int i = 0; i < 9; i++) {
			if(val == puzzle[i][c]) return false;
		}
		for(int i = 0; i < 9; i++) {
			if(val == puzzle[r][i]) return false;
		}
		for(int i = (r / 3) * 3; i < (r / 3) * 3 + 3; i++) {
			for(int j = (c / 3) * 3; j < (c / 3) * 3 + 3; j++) {
				if(val == puzzle[i][j]) return false;
			}
		}
		return true;
	}
}
