package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9093_단어뒤집기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringBuilder sb = new StringBuilder();
			String[] arr = br.readLine().split(" ");
			for(int i = 0; i < arr.length; i++) {
				for(int j = arr[i].length() - 1; j >= 0; j--) {
					sb.append(arr[i].charAt(j));
				}
				sb.append(" ");
			}
			System.out.println(sb);
		}
	}
}
