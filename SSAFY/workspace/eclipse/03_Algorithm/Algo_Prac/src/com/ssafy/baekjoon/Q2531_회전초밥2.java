package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2531_회전초밥2 {
	static int N, D, K, C, ans;
	static int[] list, sushi;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new int[N + K];
		sushi = new int[D + 1];
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < K; i++) {
			list[N + i] = list[i];
		}
		int cnt = 0;
		
		for(int i = 0; i < N + K; i++) {
			// 투 포인트 알고리즘 적용
			if(sushi[list[i]] == 0 && list[i] != C) {
				cnt++;
			}
			sushi[list[i]]++;
			if(i - K >= 0) {
				sushi[list[i - K]]--;
				if(sushi[list[i - K]] == 0 && list[i - K] != C) cnt--;
			}
			ans = Math.max(ans, cnt);
			
		}
		System.out.println(ans + 1);
	}
	
}
