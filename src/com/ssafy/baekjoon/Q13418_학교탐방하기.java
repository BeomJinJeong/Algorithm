package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q13418_학교탐방하기 {
	static int N, M;
	static int[] repres;
	static PriorityQueue<load> q, dq;
	static class load {
		int from;
		int to;
		int w;
		public load(int from, int to, int w) {
			super();
			this.from = from;
			this.to = to;
			this.w = w;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()) + 1;
		q = new PriorityQueue<>((o1, o2) -> (o1.w - o2.w));
		dq = new PriorityQueue<>((o1, o2) -> (o2.w - o1.w));
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			q.add(new load(from, to, w));
			dq.add(new load(from, to, w));
		}
		
		int edge = 0;
		makeSet();
		while(!q.isEmpty()) {
			load cur = q.poll();
			if(union(cur.from, cur.to)) {
				edge += cur.w;
			}			
		}
		edge = N - edge;
		int max = edge * edge;
		
		edge = 0;
		makeSet();
		while(!dq.isEmpty()) {
			load cur = dq.poll();
			if(union(cur.from, cur.to)) {
				edge += cur.w;
			}			
		}
		edge = N - edge;
		int min = edge * edge;
		System.out.println(max - min);
	}
	private static void makeSet() {
		repres = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			repres[i] = i;
		}
	}
	private static int find(int a) {
		if(repres[a] == a) return a;
		return repres[a] = find(repres[a]);
	}
	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return false;
		repres[a] = b;
		return true;
	}
}
