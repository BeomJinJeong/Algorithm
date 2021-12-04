package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10819_차이를최대로 {
	static int N, ans;
	static int[] arr, res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];	
		res = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[N];
		dfs(check, 0);
		System.out.println(ans);
	}
	public static void dfs(boolean[] check, int cnt) {
		if(cnt == N) {
			int sum = 0;
			for(int i = 1; i < N; i++) {
				sum += Math.abs(res[i - 1] - res[i]);
			}
			if(sum >= ans) ans = sum;
			return;
		}
		for(int i = 0; i < N; i++) {
			if(check[i]) continue;
			res[cnt] = arr[i];
			check[i] = true;
			dfs(check, cnt + 1);
			check[i] = false;
		}
	}
}
