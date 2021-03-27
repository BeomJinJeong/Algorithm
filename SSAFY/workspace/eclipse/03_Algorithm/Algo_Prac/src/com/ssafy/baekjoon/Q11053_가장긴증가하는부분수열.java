package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		int[] D = new int[N];
		String[] str = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(str[i]);
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			D[i] = 1;
			for(int j = 0; j < i; j++) {
				if(list[i] > list[j]) {
					D[i] = Math.max(D[i], D[j] + 1);
				}
			}
			max = Math.max(max, D[i]);
		}
		System.out.println(max);
	}
}
