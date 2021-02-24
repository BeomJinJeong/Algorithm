package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14501_퇴사 {
	static int N, max = Integer.MIN_VALUE;
	static int[][] plan;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		plan = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			plan[i][0] = Integer.parseInt(st.nextToken());
			plan[i][1] = Integer.parseInt(st.nextToken());
		}
		solve(0, 0);
		System.out.println(max);
	}
	private static void solve(int cnt, int value) {
		if(cnt >= N) {
			max = Math.max(max, value);
			return;
		}
		if(cnt + plan[cnt][0] <= N) solve(cnt + plan[cnt][0], value + plan[cnt][1]);
		else solve(cnt + plan[cnt][0], value);
		
		solve(cnt + 1, value);
	}
}
