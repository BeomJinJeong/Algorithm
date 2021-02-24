package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2564_경비원 {
	static int R, C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		int[] arr = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			switch(r) {
			case 1:
				arr[i] = c;
				break;
			case 2:
				arr[i] = C + R + (C-c);
				break;
			case 3:
				arr[i] = C * 2 + R + (R-c);
				break;
			case 4:
				arr[i] = C + c;
				break;
			}
		}	
		int sum = 0;
		for(int j = 0; j < N; j++) {
			int a = Math.abs(arr[j] - arr[N]);
			int b = Math.abs((2 * R) + (2 * C) - a);
			sum += Math.min(a, b);
		}
		System.out.println(sum);
	}
}
