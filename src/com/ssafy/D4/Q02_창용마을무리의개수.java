package com.ssafy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q02_창용마을무리의개수 {
	static int N;
	static int[] p;
	
	static void make() {
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}
	static int findSet(int a) {
		if(p[a] == a) return a;
		return p[a] = findSet(p[a]);
	}
	static void union(int a, int b) {
		p[findSet(b)] = findSet(a);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
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
			HashSet<Integer> h = new HashSet<>();
			for(int i = 1; i <= N; i++) {
				h.add(findSet(i));
			}
			System.out.println("#" + t + " " + h.size());
		}
	}
}
