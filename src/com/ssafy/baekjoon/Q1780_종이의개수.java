package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1780_종이의개수 {
	static int[][] pap;
	static int N;
	static int[] cnt = new int[3];	// {0, 1, 2}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pap = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				pap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		con(0, 0, N);
		for(int a : cnt) {
			System.out.println(a);
		}
	}
	private static boolean check(int r, int c, int n) {
		int a = pap[r][c];
		for(int i = r; i < r + n; i++) {
			for(int j = c; j < c + n; j++) {
				if(pap[i][j] != a) return false;
			}
		}
		return true;
	}
	private static void con(int r, int c, int n) {
		if(check(r, c, n)) {
			cnt[pap[r][c] + 1]++;
		} else {
			int size = n / 3;
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					con(r + size * i, c + size * j, size);
				}
			}
		}
	}
}
