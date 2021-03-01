package com.ssafy.baekjoon;

import java.util.Scanner;

public class Q2447_별찍기 {
	static int N;
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = ' ';
			}
		}
		div(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	
	private static void div(int r, int c, int n) {
		if(n == 1) {
			map[r][c] = '*';
			return;
		}
		int size = n / 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) continue;
				div(r + size * i, c + size * j, size);
			}
		}
	}
}
