package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11_맥주마시면서걸어가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N + 2][2];
			for(int i = 0; i < N + 2; i++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0; j < 2; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			boolean[][] check = new boolean[N + 2][N + 2];
			int[][] list = new int[N + 2][N + 2];
			for(int i = 0; i < N + 2; i++) {
				for(int j = 0; j < N + 2; j++) {
					if(i == j) continue;
					list[i][j] = getDist(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
					if(list[i][j] <= 1000) {
						check[i][j] = true;
					}
				}
			}
			for(int k = 0; k < N + 2; ++k) {
				for(int i = 0; i < N + 2; ++i) {
					if(i == k) continue;
					for(int j = 0; j < N + 2; ++j) {
						if(i == j || k == j) continue;
						if(list[i][j] > list[i][k] + list[k][j]) {
							list[i][j] = list[i][k] + list[k][j];							
						}
						if(check[i][k] && check[k][j]) {
							check[i][j] = true;
						}
						
					}
				}
			}
			System.out.println(check[0][N + 1] ? "happy" : "sad");
//			if(list[0][N + 1] <= 1000*(N + 1) && flag) System.out.println("happy");
//			else System.out.println("sad");
		}
	}
	private static int getDist(int x, int y, int dx, int dy) {
		return Math.abs(x - dx) + Math.abs(y - dy); 
	}
}
