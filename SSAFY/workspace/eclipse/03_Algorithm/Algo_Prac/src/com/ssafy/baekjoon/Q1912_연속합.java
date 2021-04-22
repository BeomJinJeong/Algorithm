package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1912_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		dp[0] = arr[0];
		for(int i = 1; i < N; i++) {
			if(dp[i - 1] + arr[i] > arr[i]) {
				dp[i] = dp[i - 1] + arr[i];
			} else {
				dp[i] = arr[i];
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N - 1]);
	}
}
