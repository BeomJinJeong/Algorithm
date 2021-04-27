package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1005_ACMCraft {
	static ArrayList<Integer>[] list;
	static int[] arr, dp;
	static boolean[] check;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[N + 1];
			dp = new int[N + 1];
			check = new boolean[N + 1];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i + 1] = Integer.parseInt(st.nextToken());
				dp[i + 1] = arr[i + 1];
			}
			list = new ArrayList[N + 1];
			for(int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[to].add(from);
			}
			int target = Integer.parseInt(br.readLine());
			System.out.println(dfs(target));
		}
	}
	private static int dfs(int target) {		
		int size = list[target].size();
		
		for(int i = 0; i < size; i++) {			
			if(!check[target]) {
				int result = dfs(list[target].get(i));
				if(result + arr[target] > dp[target]) {
					dp[target] = result + arr[target]; 
				}
			} else {
				if(dp[list[target].get(i)] + arr[target] > dp[target]) {
					dp[target] = dp[list[target].get(i)] + arr[target];
				}
			}
		}
		check[target] = true;
		return dp[target];
	}
}
