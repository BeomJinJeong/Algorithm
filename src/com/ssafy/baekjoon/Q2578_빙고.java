package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2578_빙고 {
	static int[][] map;
	static int cnt = 0, r, c, next;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				next++;
				loc(Integer.parseInt(st.nextToken()));
				map[r][c] = 0;
				if(next >= 5) {
					check();
					if(cnt >= 3) {
						System.out.println(next);
						return;
					}
				}
			}
		}
		
	}
	public static void check() {
		int sum = 0, k = 0, lCnt = 0;
		for(int i = 0; i < 5; i++) {
			sum += map[k][k++];
		}
		if(sum == 0) lCnt++;
		sum = 0; k = 0;
		for(int i = 0; i < 5; i++) {
			sum += map[4 - k][k++]; 
		}
		if(sum == 0) lCnt++;
		for(int i = 0; i < 5; i++) {
			sum = 0;
			for(int j = 0; j < 5; j++) {
				sum += map[i][j];
			}
			if(sum == 0) lCnt++;
		}
		for(int j = 0; j < 5; j++) {
			sum = 0;
			for(int i = 0; i < 5; i++) {
				sum += map[i][j];
			}
			if(sum == 0) lCnt++;
		}
		cnt = Math.max(cnt, lCnt);
	}
	public static void loc(int val) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(val == map[i][j]) {
					r = i; c = j;
					return;
				}
			}
		}
	}
}
