package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1113_수영장만들기 {
	static int N, M, limit, ans;
	static int[][] map, tmpMap, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tmpMap = new int[N][M];
		check = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(tmpMap[i], 0);
		}
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
	}
	private static boolean inRange(int r, int c) {
		return (r < N && r >= 0 && c < M && c >= 0);
	}
}
