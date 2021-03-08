package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2785_체인 {
	static int sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		Arrays.sort(arr);
		int idx = 0, lIdx = 0, cnt = 0;
		while(true) {
			if(arr[idx] == 0) idx++;
			arr[idx]--;
			arr[arr.length - lIdx - 2] += arr[arr.length - lIdx - 1] + 1;
			arr[arr.length - lIdx - 1] = 0;
			if(arr[arr.length - lIdx - 2] == sum) break;
			lIdx++;
			cnt++;
		}
		System.out.println(cnt);
		
	}
}
