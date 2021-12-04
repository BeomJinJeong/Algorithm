package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q5557_1학년 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		ArrayList<Integer>[] list = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		list[0].add(arr[0]);
		dp[0] = 1;
		
		for(int i = 1; i < N - 1; i++) {
			for(int j = 0; j < list[i - 1].size(); j++) {
				int a1 = list[i - 1].get(j) + arr[i];
				int a2 = list[i - 1].get(j) - arr[i];
				
				if(a1 >= 0 && a1 <= 20) list[i].add(a1);
				if(a2 >= 0 && a2 <= 20) list[i].add(a2);
			}
			dp[i] = list[i].size();
		}
		int ans = 0;
		for(int i = 0; i < list[N - 2].size(); i++) {
			if(list[N - 2].get(i) == arr[N - 1]) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
