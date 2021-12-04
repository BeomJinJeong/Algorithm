package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q14696_딱지놀이 {
	static int[] statA, statB;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		statA = new int[5];
		statB = new int[5];
		for(int i = 0; i < N * 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; j++) {
				int shape = Integer.parseInt(st.nextToken());
				if(i % 2 == 0) { statA[shape] += 1; }
				else if(i % 2 == 1) { statB[shape] += 1; }
			}
			if(i % 2 != 0) {
				getWinner();
				Arrays.fill(statA, 0);
				Arrays.fill(statB, 0);
			}
		}
	}
	public static void getWinner() {
		for(int i = 4; i >= 1; i--) {
			if(statA[i] == statB[i]) continue;
			else {
				System.out.println(statA[i] > statB[i] ? "A" : "B");
				return;
			}
		}
		System.out.println("D");
	}
}
