package com.ssafy.baekjoon;

import java.util.Scanner;

public class Q10_RGB거리 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] list = new int[N][3];
		int[][] dp = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				list[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < 3; i++) {
			dp[0][i] = list[0][i];
		}
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + list[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + list[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + list[i][2];
		}
		System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
		sc.close();
	}
}
