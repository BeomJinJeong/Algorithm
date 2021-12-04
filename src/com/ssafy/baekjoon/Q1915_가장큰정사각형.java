package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1915_가장큰정사각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		int[][] dp = new int[N][M];
		for(int i = 0; i < M; i++) {
			dp[0][i] = arr[0][i];
		}
		for(int i = 1; i < N; i++) {
			dp[i][0] = arr[i][0];
		}
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < M; j++) {
				if(arr[i - 1][j] == 1 && arr[i - 1][j - 1] == 1 && arr[i][j - 1] == 1 && arr[i][j] == 1) {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
				} else {
					dp[i][j] = arr[i][j];
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(ans < dp[i][j]) ans = dp[i][j];
			}
		}
		System.out.println(ans * ans);
	}
}
