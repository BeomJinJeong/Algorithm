package com.ssafy.baekjoon;

import java.io.*;
import java.util.*;
public class Q2096_내려가기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] min = new int[N][3];
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		min[0][0] = arr[0][0];
		min[0][1] = arr[0][1];
		min[0][2] = arr[0][2];
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) {
					min[i][j] = Math.min(min[i - 1][0], min[i - 1][1]) + arr[i][j];
					arr[i][j] = Math.max(arr[i - 1][0], arr[i - 1][1]) + arr[i][j];
				} else if(j == 2) {
					min[i][j] = Math.min(min[i - 1][2], min[i - 1][1]) + arr[i][j];
					arr[i][j] = Math.max(arr[i - 1][2], arr[i - 1][1]) + arr[i][j];
				} else {
					min[i][j] = Math.min(Math.min(min[i - 1][0], min[i - 1][1]), min[i - 1][2]) + arr[i][j];
					arr[i][j] = Math.max(Math.max(arr[i - 1][0], arr[i - 1][1]), arr[i - 1][2]) + arr[i][j];
				}
			}
		}
		int ansMax = Math.max(Math.max(arr[N - 1][0], arr[N - 1][1]), arr[N - 1][2]);
		int ansMin = Math.min(Math.min(min[N - 1][0], min[N - 1][1]), min[N - 1][2]);
		System.out.println(ansMax + " " + ansMin);
	}
}
