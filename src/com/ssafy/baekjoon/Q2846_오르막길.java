package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2846_오르막길 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int maxHeight = arr[0];
		int minHeight = arr[0];
		for(int i = 1; i < N; i++) {
			if(arr[i - 1] < arr[i]) {
				maxHeight = arr[i];
				ans = Math.max(ans, maxHeight - minHeight);
			} else {
				minHeight = arr[i];
				maxHeight = arr[i];
			}
		}
		System.out.println(ans);
	}
}
