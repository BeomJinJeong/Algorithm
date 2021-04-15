package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1504_특정한최단경로 {
	static int N, E, r1, r2, INF = 200000000, ans = Integer.MAX_VALUE;
	static ArrayList<int[]>[] list;
	static int[] dist;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist = new int[N + 1];
		list = new ArrayList[N + 1];
		for(int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to, weight});
			list[to].add(new int[] {from, weight});
		}
		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		
		System.out.println(solve());
	}
	private static int solve() {
		int m1 = 0, m2 = 0;
		
		m1 += dij(1, r1);
		m1 += dij(r1, r2);
		m1 += dij(r2, N);
		
		m2 += dij(1, r2);
		m2 += dij(r2, r1);
		m2 += dij(r1, N);
		
		ans = Math.min(m1, m2);
		if(ans >= INF) return -1;
		else return ans;
		
	}
	private static int dij(int start, int end) {
		Arrays.fill(dist, INF);
		boolean[] check = new boolean[N + 1];
		
		PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->(o1[1] - o2[1]));
		q.add(new int[] {start, 0});
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int curPos = cur[0];
			int curWeight = cur[1];
			
			if(!check[curPos]) {
				check[curPos] = true;
				
				for(int i = 0; i < list[curPos].size(); i++) {
					int nextPos = list[curPos].get(i)[0];
					int nextWeight = list[curPos].get(i)[1];
					
					if(!check[nextPos] && dist[nextPos] > curWeight + nextWeight) {
						dist[nextPos] = curWeight + nextWeight;
						q.add(new int[] {nextPos, dist[nextPos]});
					}
				}
			}
		}
		return dist[end];
	}
}
