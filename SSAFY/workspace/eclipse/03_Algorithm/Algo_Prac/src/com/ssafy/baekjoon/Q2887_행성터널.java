package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2887_행성터널 {
	static int N;
	static long ans;
	static int[] repres;
	static Star[] stars;
	static PriorityQueue<Node> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stars = new Star[N];
		make();
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			stars[i] = new Star(i, x, y, z);
		}
		solve();
	}
	private static void solve() {
		q = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Long.compare(o1.weight, o2.weight);
			}			
		});
		Arrays.sort(stars, new Comparator<Star>() {
			@Override
			public int compare(Star o1, Star o2) {
				return o1.x - o2.x;
			}			
		});
		for(int i = 0; i < N - 1; i++) {
			q.offer(new Node(stars[i].no, stars[i + 1].no, getDist(stars[i], stars[i + 1])));
		}
		
		Arrays.sort(stars, new Comparator<Star>() {
			@Override
			public int compare(Star o1, Star o2) {
				return o1.y - o2.y;
			}			
		});
		for(int i = 0; i < N - 1; i++) {
			q.offer(new Node(stars[i].no, stars[i + 1].no, getDist(stars[i], stars[i + 1])));
		}
		
		Arrays.sort(stars, new Comparator<Star>() {
			@Override
			public int compare(Star o1, Star o2) {
				return o1.z - o2.z;
			}			
		});
		for(int i = 0; i < N - 1; i++) {
			q.offer(new Node(stars[i].no, stars[i + 1].no, getDist(stars[i], stars[i + 1])));
		}
		
		int sum = 0, cnt = 0;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(find(cur.from) != find(cur.to)) {
				union(cur.from, cur.to);
				sum += cur.weight;
				cnt++;
			}
			if(cnt == N - 1) break;
		}
		System.out.println(sum);
	}
	private static void make() {
		repres = new int[N + 1];
		for(int i = 0; i < repres.length; i++) {
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
	private static long getDist(Star a, Star b) {
		return Math.min(Math.min(Math.abs(a.x - b.x), Math.abs(a.y - b.y)), Math.abs(a.z - b.z));
	}
	static class Star {
		int no, x, y, z;
		
		public Star(int no, int x, int y, int z) {
			super();
			this.no = no;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	static class Node {
		int from;
		int to;
		long weight;
		
		public Node(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}		
	}
}
