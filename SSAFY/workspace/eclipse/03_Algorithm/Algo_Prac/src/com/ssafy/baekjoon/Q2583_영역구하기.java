package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2583_영역구하기 {
	static boolean[][] map, check;
	static int N, M, K;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, 1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for(int k = r; k < h; k++) {
				for(int j = c; j < w; j++) {
					map[k][j] = true;
				}
			}
		}
		
	}
	public static boolean dfs(int r, int c) {
		
	}
}
