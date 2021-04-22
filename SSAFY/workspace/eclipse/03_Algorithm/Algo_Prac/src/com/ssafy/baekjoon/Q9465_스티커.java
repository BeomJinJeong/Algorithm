package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465_스티커 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N];
			
			StringTokenizer st = null;
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dp = new int[2][N];
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			
			for(int i = 1; i < N; i++) {
				if(dp[0][i - 1] + arr[1][i] > dp[1][i - 1]) {
					dp[1][i] = dp[0][i - 1] + arr[1][i];
				} else dp[1][i] = dp[1][i - 1];
				if(dp[1][i - 1] + arr[0][i] > dp[0][i - 1]) {
					dp[0][i] = dp[1][i - 1] + arr[0][i];
				} else dp[0][i] = dp[0][i - 1];
			}
			System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
		}
	}
}
