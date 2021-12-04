package com.ssafy.baekjoon;


import java.io.*;
public class Q1699_제곱수의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] power = new int[100001];
		for(int i = 1; i <= 100000; i++) {
			power[i] = (int)Math.pow(i, 2);
		}
		int ans = 0;
		while(N > 0) {
			for(int i = 100000; i >= 0; i--) {
				if(power[i] <= N) {
					N -= power[i];
					break;
				}
			}
			ans++;
		}
		System.out.println(ans);
	}
}
