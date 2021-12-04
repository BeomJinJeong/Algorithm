package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q17103_골드바흐파티션 {	// 다시
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] prime = new boolean[1000001];
		for(int i = 2; i < Math.sqrt(1000001); i++) {
			for(int j = 2; i * j < 1000001; j++) {
				if(prime[i * j]) continue;
				prime[i * j] = true;
			}
		}
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			
		}
	}
}
