package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1932_정수삼각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] list = new int[N][N];
		StringTokenizer st=  null;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i; j++) {
				list[i - 1][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					list[i][j] += list[i - 1][j];
				} else if(j == i) {
					list[i][j] += list[i - 1][j - 1];
				} else {
					list[i][j] += Math.max(list[i - 1][j - 1], list[i - 1][j]);
				}
				max = Math.max(max, list[i][j]);
			}
		}
		System.out.println(max);
	}
}
