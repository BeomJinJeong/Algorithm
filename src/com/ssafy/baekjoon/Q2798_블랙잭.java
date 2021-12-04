package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2798_블랙잭 {
	static int[] input, res;
	static int N, M, max = Integer.MIN_VALUE; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		res = new int[3];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			input[i] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0);
		System.out.println(max);
	}
	public static void comb(int cnt, int start) {
		if(cnt == 3) {
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				sum += res[i];
			}
			if(sum <= M) {
				max = Math.max(sum, max);
			}
			return;
		}
		for(int i = start; i < N; i++) {
			res[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
}
