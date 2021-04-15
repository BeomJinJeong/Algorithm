package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q2531_회전초밥 {
	static int N, D, K, C, ans;
	static int[] list;
	static int[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new int[N];
		result = new int[K];
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		HashSet<Integer> set = new HashSet<>();
		int start = 0;
		boolean flag = false;
		while(!flag) {
			for(int i = start; i < start + K; i++) {
				set.add(list[i % N]);				
			}
			if(!set.contains(C)) set.add(C);
			ans = Math.max(ans, set.size());
			set.clear();
			start = (start + 1) % N;
			if(start == 0) flag = true;
		}
		System.out.println(ans);
	}
	
}
