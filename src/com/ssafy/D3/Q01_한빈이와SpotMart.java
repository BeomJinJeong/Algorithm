package com.ssafy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q01_한빈이와SpotMart {
	static int N,M;
	static int[] snacks, result;
	static int max = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snacks = new int[N];
			result = new int[2];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			comb(0, 0);
			if(max == 0) max = -1;
			System.out.println("#" + t + " " + max);
			max = 0;
		}
	}
	public static void comb(int cnt, int start) {
		if(cnt == 2) {
			int sum = 0;
			for(int i = 0; i < 2; i++) {
				sum += result[i];
			}
			if(sum <= M) {
				max = Math.max(sum, max);
			}
			return;
		}
		for(int i = start; i < N; i++) {
			result[cnt] = snacks[i];
			comb(cnt+1, i+1);
		}
	}
}
