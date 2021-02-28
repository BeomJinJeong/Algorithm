package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2491_수열 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0, max = 0;
		
		for(int i = 0; i < N - 1; i++) {
			int res = arr[i] - arr[i+1];
			if(res >= 0) {
				cnt++;
				max = Math.max(max, cnt);
			} else cnt = 0;
		}
		cnt = 0;
		for(int i = 0; i < N - 1; i++) {
			int res = arr[i] - arr[i + 1];
			if(res <= 0) {
				cnt++;
				max = Math.max(max, cnt);
			} else cnt = 0;
		}
		System.out.println(max + 1);
	}
}
