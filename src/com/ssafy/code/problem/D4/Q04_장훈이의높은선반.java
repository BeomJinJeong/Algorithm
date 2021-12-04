package com.ssafy.code.problem.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q04_장훈이의높은선반 {
	static boolean[] check;
	static int min;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			check = new boolean[N];
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			po(arr, 0, N, B);
			System.out.println("#" + t + " " + min);
		}
	}
	private static void po(int[] arr, int cnt, int N, int B) {
		if(cnt == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(check[i]) {
					sum += arr[i];
				}
			}
			if(sum >= B) {
				min = Math.min(sum - B,  min);
			}
			return;
		}
		check[cnt] = true;
		po(arr, cnt + 1, N, B);
		check[cnt] = false;
		po(arr, cnt + 1, N, B);
	}
}
