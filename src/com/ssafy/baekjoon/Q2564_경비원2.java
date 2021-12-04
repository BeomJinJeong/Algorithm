package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2564_경비원2 {
	static int R, C;
	static int sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int[][] arr = new int[N + 1][2];
		for(int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			switch(r) {
			case 1:
				arr[i][0] = 0;
				arr[i][1] = c;
				break;
			case 2:
				arr[i][0] = R;
				arr[i][1] = c;
				break;
			case 3:
				arr[i][0] = c;
				arr[i][1] = 0;
				break;
			case 4:
				arr[i][0] = c;
				arr[i][1] = C;
				break;
			}
		}
		for(int i = 0; i < N; i++) {
			getDis(arr[i], arr[N]);
		}
		System.out.println(sum);
	}
	private static void getDis(int[] arr, int[] from) {
		if(from[0] == arr[0]) { // 남북 같은 라인
			sum += Math.abs(arr[1] - from[1]);
		} else if(Math.abs(arr[0] - from[0]) == R) { // 남북 마주볼때
			int a = arr[1] + from[1] + R;
			int b = (C - arr[1]) + (C - from[1]) + R;
			sum += Math.min(a, b);
		} else {
			if( arr[0] == 0 ) {  // 상점 왼쪽
				if(from[1] == 0) {
					sum += Math.abs(arr[0] - from[0]) + arr[1];
				} else {
					sum += Math.abs(arr[0] - from[0]) + C - arr[1];
				}
			} else if(arr[0] == R) { // 상점 오른쪽
				if(from[1] == 0) {
					sum += Math.abs(arr[0] - from[0]) + arr[1];
				} else {
					sum += Math.abs(arr[0] - from[0]) + C - arr[1];
				}				
			} else {
				if(arr[1] == 0) {
					if(from[1] == 0) {
						sum += Math.abs(arr[0] - from[0]);
					} else if(from[1] == C) {
						sum += arr[0] + from[0] + C;
					} else if(from[0] == 0){
						sum += from[1] + arr[0];
					} else if(from[0] == R) {
						sum += from[1] + (R - arr[0]);
					}
				} else if(arr[1] == C) {
					if(from[1] == 0) {
						sum += arr[0] + from[0] + C;
					} else if(from[1] == C) {
						sum += Math.abs(arr[0] - from[0]);
					} else if(from[0] == 0){
						sum += (C - from[1]) + arr[0];
					} else if(from[0] == R) {
						sum += (C - from[1]) + (R - arr[0]);
					}
				}
			}
		}
	}
}
