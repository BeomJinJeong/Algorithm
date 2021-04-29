package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2293_동전1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[K + 1];
		
		dp[0] = 1;
		
		for(int i = 0; i < N; i++) {
			for(int j = coins[i]; j < dp.length; j++) {
				dp[j] += dp[j - coins[i]];
			}
		}
		System.out.println(dp[K]);
	}
}
