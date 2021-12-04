package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07_쿼드트리 {
	static int N;
	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		sb = new StringBuilder();
		for(int i = 0;  i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
			}
			
		}
		tree(0, 0, N);
		System.out.println(sb.toString());
	}
	private static boolean checkIn(int row, int col, int size) {
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(map[i][j] != map[row][col])
					return false;
			}
		}
		return true;
	}
	private static void tree(int r, int c, int n) {
		if(checkIn(r, c, n)) {
			sb.append(map[r][c]);
		} else {
			sb.append("(");
			int newSize = n / 2;
			
			tree(r, c, newSize);
			tree(r, c + newSize, newSize);
			tree(r + newSize, c, newSize);
			tree(r + newSize, c + newSize, newSize);
			
			sb.append(")");
		}
	}
}
