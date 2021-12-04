package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q16922_로마숫자만들기 {
	static int[] input = {1, 5, 10, 50};
	static boolean[] check; 
	static int N, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check = new boolean[1001];
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= N - i; j++) {
				for(int k = 0; k <= N - i - j; k++) {
					int l = N - i - j - k;
					int sum = i + 5*j + 10*k + 50*l;
					check[sum] = true;
				}
			}
		}
		for(int i = 0; i < 1001; i++) {
			if(check[i]) ans++;
		}
		System.out.println(ans);
	}
}
