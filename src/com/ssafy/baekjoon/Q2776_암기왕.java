package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2776_암기왕 {
	static StringBuilder sb = new StringBuilder();
	static int[] set;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N1 = Integer.parseInt(br.readLine());
			set = new int[N1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N1; i++) {
				set[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(set);
			
			int N2 = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N2; i++) {
				int num = Integer.parseInt(st.nextToken());
				binarySearch(num);
			}
		}
		System.out.println(sb);
	}
	private static void binarySearch(int n) {
		int start, mid, end;
		start = 0;
		end = set.length - 1;
		
		while(start <= end) {
			mid = (start + end) / 2;
			if(n == set[mid]) {
				sb.append(1 + "\n");
				return;
			} else if(set[mid] > n) end = mid - 1;
			else start = mid + 1;
		}
		sb.append(0 + "\n");
	}
}
