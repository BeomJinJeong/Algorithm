package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q16500_문자열판별 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++) {
			s = s.replaceAll(arr[i], "0");
		}
		for(int i = 0; i < s.length(); i++) {
			if(!s.substring(i, i + 1).equals("0")) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}
}
