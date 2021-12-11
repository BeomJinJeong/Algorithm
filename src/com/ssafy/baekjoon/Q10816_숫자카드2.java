package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q10816_숫자카드2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(map.get(a) == null) map.put(a, 1);
			else {
				int cnt = map.get(a);
				map.remove(a);
				map.put(a, cnt + 1);
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(map.get(a) == null) sb.append(0 + " ");
			else sb.append(map.get(a)+ " ");
		}
		System.out.println(sb.toString());
	}
}
