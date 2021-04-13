package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10422_괄호 {	// 다시
	static int N, ans;
	static int[] input, res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			if(N == 2) {
				System.out.println(1);
				continue;
			}
			input = new int[N];
			res = new int[N];
			for(int i = 0; i < N; i++) {
				if(i < N / 2) input[i] = 1;
				else input[i] = -1;
			}
			comb(1, 1);
			System.out.println(ans);
			ans = 0;
		}
	}
	private static void comb(int cnt, int start) {
		if(cnt == N - 2) {
			ans++;
			return;
		}
		for(int i = start; i < N - 1; i++) {
			res[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
}
