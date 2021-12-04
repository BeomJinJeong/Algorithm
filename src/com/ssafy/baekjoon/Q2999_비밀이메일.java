package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2999_비밀이메일 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = 0, c = 0;
		char[] arr = br.readLine().toCharArray();
		for(int i = 0; i <= arr.length; i++) {
			for(int j = 0; j <= arr.length; j++) {
				if(i * j == arr.length) {
					if(i > r && i <= j) {
						r = i; c = j;
					}
				}
			}
		}
		int idx = 0;
		char[][] map = new char[r][c];
		for(int j = 0; j < c; j++) {
			for(int i = 0; i < r; i++) {
				map[i][j] = arr[idx++];
			}
		}
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
		}
	}
}
