package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q16463_13일의금요일 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int ans = 0;
		int date = 2;
		for(int i = 2019; i <= N; i++) {
			if(i % 400 == 0 || (i % 100 != 0 && i % 4 == 0)) {
				month[1] = 29;
			} else month[1] = 28;
			if(i % 400 != 0 && i % 100 == 0) month[1] = 28;
			for(int k = 0; k < 12; k++) {
				for(int j = 1; j <= month[k]; j++) {
					if(date == 5 && j == 13) {
						ans++;
					}
					date = (++date % 7);
				}
			}
		}
		System.out.println(ans);
	}
}	
