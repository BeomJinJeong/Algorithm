package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2937_블록정리 {
	static int[][] map, dp;
	static int M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1];
		M = Integer.parseInt(st.nextToken());
		int ans = Integer.MAX_VALUE;
		int cnt = 0;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b]++;
			if(map[a][b] != 1) cnt++;
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				dp[i][j] = dp[i - 1][j] - dp[i - 1][j - 1] + dp[i][j - 1] + map[i][j]; 
			}
		}
		
		int[] idx = new int[M + 1];
		for(int i = 1; i <= M; i++) {
			if(M % i == 0) idx[i] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				for(int k = 1; k <= M; k++) {
					if(idx[k] == 1) {
						int x1 = j;
						int y1 = i;
						int x2 = j + k - 1;
						int y2 = i + M / k - 1;
						
						if(x2 > N || y2 > N) continue;
						ans = Math.min(ans, cnt + M - (dp[y2][x2] - dp[y2][x1 - 1] - dp[y1 - 1][x2] + dp[y1 - 1][x1 - 1]));
					}
				}
			}
		}
		System.out.println(ans);
	}
}	
