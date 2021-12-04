package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1911_흙길보수하기 {
	static int cnt = 0;
	static int N, L;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		ArrayList<int[]> list = new ArrayList<>(); 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new int[] {a, b});
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[1];
			}
		});
		int start = 0;
		for(int i = 0; i < N; i++) {
			if(start < list.get(i)[0]) start = list.get(i)[0];
			while(start < list.get(i)[1]) {
				start += L;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
