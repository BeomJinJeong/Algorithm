package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889_스타트와링크 {
	static int[][] stat;
	static int N, min = 100000000;
	static int[] result;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		stat = new int[N][N];
		result = new int[N/2];
		check = new boolean[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(min);
	}
	private static void comb(int cnt, int start) {
		if(cnt == N/2) {
			min = Math.min(min, getMinDiff(result));
			return;
		}
		for(int i = start; i < N; i++) {
			result[cnt] = i;
			check[i] = true;
			comb(cnt + 1, i + 1);
			check[i] = false;
		}
	}
	private static int getMinDiff(int[] a) {
		int statA = 0, statB = 0;
		int[] remain = new int[N / 2];
		for(int i = 0, cnt = 0; i < N; i++) {
			if(!check[i]) remain[cnt++] = i;
		}
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				statA += stat[a[i]][a[j]];
			}
		}
		for(int i = 0; i < remain.length; i++) {
			for(int j = 0; j < remain.length; j++) {
				statB += stat[remain[i]][remain[j]];
			}
		}
		return Math.abs(statA - statB);
	}
}
