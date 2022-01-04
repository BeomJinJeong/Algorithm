package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1057_토너먼트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		while(lim != kim) {
			kim = (kim + 1) / 2;
			lim = (lim + 1) / 2;
			ans++;
		}
		System.out.println(ans);
	}
}
