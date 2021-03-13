package com.ssafy.SWA.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_수영장 {
	static int day, month, tMonth, year, min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			tMonth = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			int[] arr = new int[12];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			min = Math.min(min, year);
			dfs(0, 0, arr);
			System.out.println("#" + t + " " + min);
		}	
	}
	private static void dfs(int cnt, int sum, int[] arr) {
		if(cnt >= 12) {
			min = Math.min(sum, min);
			return;
		} else {
			sum += arr[cnt]*day;
			dfs(cnt + 1, sum, arr);
			sum -= arr[cnt]*day;
			sum += month;
			dfs(cnt + 1, sum, arr);
			sum -= month;
			sum += tMonth;
			dfs(cnt + 3, sum, arr);
		}
	}
}
