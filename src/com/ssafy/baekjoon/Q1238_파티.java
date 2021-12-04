package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1238_파티 {
	static class Node {
		int to, weight;

		public Node(int num, int w) {
			super();
			this.to = num;
			this.weight = w;
		}		
	}
	static int N, M, X;
	static int[] dist;
	static boolean[] check;
	static ArrayList<Node>[] list;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, weight));
		}
		
		int[] time = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			dij(i);
			time[i] += dist[X];
		}
		
		dij(X);
		
		for(int i = 1; i <= N; i++) {
			time[i] += dist[i];
		}
		
		int max = 0; 
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, time[i]);
		}
		System.out.println(max);
	}
	private static void dij(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> (o1.weight - o2.weight));
		q.add(new Node(start, 0));
		check = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, -1);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(!check[cur.to]) {
				check[cur.to] = true;
				
				for(Node n : list[cur.to]) {
					if(dist[n.to] == -1 || dist[n.to] > dist[cur.to] + n.weight) {
						dist[n.to] = dist[cur.to] + n.weight;
						q.add(new Node(n.to, dist[n.to]));
					}
				}
			}
		}
	}
}
