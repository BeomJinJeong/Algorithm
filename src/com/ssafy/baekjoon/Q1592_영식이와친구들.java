package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1592_영식이와친구들 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		int[] cnt = new int[N];
		boolean check = false;
		int idx = 0;
		while(!check) {
			if(cnt[idx] % 2 == 0) {
				if(idx - L < 0) idx += N;
				idx -= L;
				cnt[idx]++;
			} else if(cnt[idx] % 2 == 1) {
				if(idx + L >= N) idx -= N;
				idx += L;
				cnt[idx]++;
			}
			ans++;
			check = check(M, cnt);
		}
		System.out.println(ans - 1);
	}
	public static boolean check(int M, int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == M) {
				return true;
			}
		}
		return false;
	}
}
