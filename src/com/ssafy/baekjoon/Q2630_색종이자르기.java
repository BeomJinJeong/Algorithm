package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2630_색종이자르기 {
	static int[][] map;
	static int[] check = new int[2];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		div(0, 0, N);
		for(int a : check) {
			System.out.println(a);
		}
	}
	private static boolean check(int r, int c, int n) {
		int a = map[r][c];
		for(int i = r; i < r + n; i++) {
			for(int j = c; j < c + n; j++) {
				if(map[i][j] != a) return false;
			}
		}
		return true;
	}
	private static void div(int r, int c, int n) {
		if(check(r, c, n)) {
			check[map[r][c]]++;
		} else {
			int size = n / 2;
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					div(r + size * i, c + size * j, size);
				}
			}
		}
	}
}
