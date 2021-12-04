package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2156_포도주시식 {
	static int N;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < N; i++) {
			if(i == 0) dp[i] = arr[i];
			else if(i == 1) dp[i] = arr[i - 1] + arr[i];
			else if(i == 2) dp[i] = Math.max(dp[i - 1], Math.max(arr[i - 2] + arr[i], arr[i - 1] + arr[i]));
			else {
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
			}
		}
		
		int ans = 0;
		for(int i = 0; i < dp.length; i++) {
			ans = Math.max(dp[i], ans);
		}
		System.out.println(ans);
	}
}
