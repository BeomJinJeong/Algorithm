package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q14621_나만안되는연애 {
	static int N, M;
	static boolean[] isMale;
	static PriorityQueue<Edge> edges;
	static int[] repres;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isMale = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			isMale[i] = st.nextToken().equals("M");
		}
		// 간선 정보 처리
		edges = new PriorityQueue<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int ei = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			// 위 정보로 언제나 연결할 수 있는 것은 아니다. --> 남 - 여 로만 연결 가능.
			boolean canConnect = isMale[si] != isMale[ei];
			if(canConnect) {
				edges.offer(new Edge(ei, si, cost));
			}
		}
		
		makeSet();
		int sum = 0, cnt = 0;
		while(!edges.isEmpty() && cnt < N-1) {
			Edge e = edges.poll();			
			// 연결 할 수 있으면 연결해본다.
			if(union(e.si, e.ei)) {
				sum += e.cost;
				cnt++;
			}
		}
		if(cnt == N - 1) System.out.println(sum);
		else System.out.println(-1);
	}
	private static void makeSet() {
		repres = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			repres[i] = i;
		}
	}
	private static int find(int a) {
		if(repres[a] == a) return a;
		return repres[a] = find(repres[a]);
	}
	private static boolean union(int a, int b) {
		if(find(a) == find(b)) return false;
		repres[a] = b;
		return true;
	}
	private static class Edge implements Comparable<Edge>{
		int si, ei, cost;				
		public Edge(int si, int ei, int cost) {
			super();
			this.si = si;
			this.ei = ei;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

		@Override
		public String toString() {
			return "Edge [si=" + si + ", ei=" + ei + ", cost=" + cost + "]";
		}		
	}
}
