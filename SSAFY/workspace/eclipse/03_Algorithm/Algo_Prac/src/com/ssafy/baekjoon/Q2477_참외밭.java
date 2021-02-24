package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2477_참외밭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[6][2];
		int maxW = 0, maxH = 0, maxWIn = 0, maxHIn = 0;
		for(int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			if(arr[i][0] == 3 | arr[i][0] == 4 && arr[i][1] > maxW) {
				maxW = arr[i][1];
				maxWIn = i;
			}
			else if(arr[i][0] == 1 | arr[i][0] == 2 && arr[i][1] > maxH) {
				maxH = arr[i][1];
				maxHIn = i;
			}
		}
		int minWIn = maxHIn + 3;
		if(minWIn >= 6) minWIn -= 6;
		int minHIn = maxWIn + 3;
		if(minHIn >= 6) minHIn -= 6;
		int W = (arr[maxWIn][1] * arr[maxHIn][1]) - (arr[minWIn][1] * arr[minHIn][1]);
		System.out.println(W * N);
	}
}
