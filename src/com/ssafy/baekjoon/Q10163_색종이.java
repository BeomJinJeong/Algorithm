package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10163_색종이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		
		int count = 1;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for(int j = r; j < r + height; j++) {
				for(int k = c; k < c + width; k++) {
					map[j][k] = count;
				}
			}
			count++;
		}
		
		int[] cnt = new int[N + 1];
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(map[i][j] != 0) cnt[map[i][j]]++;
			}
		}
		for(int i = 1; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
	}
}
