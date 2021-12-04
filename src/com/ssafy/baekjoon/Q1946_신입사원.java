package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1946_신입사원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] arr2 = new int[N];
			int count = 1;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a - 1] = b;
				arr2[b - 1] = a;
			}
			int idx = arr[0];
			for(int i = 1; i < N; i++) {
				if(idx > arr[i]) {
					count++;
					idx = arr[i];
				}
			}
			System.out.println(count);
		}
	}
}
