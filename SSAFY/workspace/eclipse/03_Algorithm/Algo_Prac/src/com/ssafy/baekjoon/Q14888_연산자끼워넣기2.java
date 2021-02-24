package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888_연산자끼워넣기2 {
	static int[] number, oper, result, operIn = {0, 1, 2, 3};
	static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		oper = new int[4];
		result = new int[N - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int cnt) {
		if(cnt == N - 1) {
			solve(result);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(oper[i] > 0) {
				result[cnt] = operIn[i];
				oper[i]--;
				dfs(cnt + 1);
				oper[i]++;
			}
		}
	}
	private static void solve(int[] result) {
		int ans = number[0];
		for(int i = 0; i < result.length; i++) {
			switch(result[i]) {
			case 0:
				ans += number[i + 1];
				break;
			case 1:
				ans -= number[i + 1];
				break;
			case 2:
				ans *= number[i + 1];
				break;
			case 3:
				ans /= number[i + 1];
				break;
			}
		}
		min = Math.min(min, ans);
		max = Math.max(max, ans);
		
	}
}
