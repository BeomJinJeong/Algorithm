package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q258_기숙사바닥 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int x = 0, y = 0;
		for(int i = 1; i <= 2000000; i++) {
			if((R/2 - i - 1)*(i - 1) == B) {
				y = i;
				break;
			}
		}
		x = R/2 - y;
		System.out.println(Math.max(x + 1, y + 1) + " " + Math.min(x + 1, y + 1));
	}
}
