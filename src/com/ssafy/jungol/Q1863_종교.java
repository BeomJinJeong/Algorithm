package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1863_종교 {
	static int N;
	static int[] p;
	
	static void make() {
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}
	static int findSet(int a) {
		if(a == 0) return 0;
		if(p[a] == a) return a;
		return p[a] = findSet(p[a]);
	}
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		
		p[bRoot] = findSet(a);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		p = new int[N + 1];
		make();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		int cnt = 0;
		for(int i = 1; i < p.length; i++) {
			if(i == p[i]) cnt++;
		}
		System.out.println(cnt);
	}
}
