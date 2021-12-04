package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2616_소형기관차 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[N + 1];
		int[] sum = new int[N + 1];
		int[][] dp = new int[4][N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		int L = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			if(i - L > 0) {
				for(int j = i - L + 1; j <= i; j++) {
					sum[i] += cnt[j];
				}
			} else {
				sum[i] = sum[i - 1] + cnt[i];
			}
		}
		
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= N; j++) {
				if(j - L >= 0) {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - L] + sum[j]);
				} 
			}
		}
		System.out.println(dp[3][N]);
	}
}
