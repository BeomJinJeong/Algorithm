package com.ssafy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q03_하나로 {
	static class Pos{
		int x;
		int y;
		double weight;
		public Pos(int x, int y, double weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
	static Pos[] island;
	static int[] parent;
	static double E;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			island = new Pos[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				island[i] = new Pos(Integer.parseInt(st.nextToken()), 0, 0);
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				island[i].y = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			ArrayList<Pos> weights = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					weights.add(new Pos(j, i, getWeight(island[i].x, island[i].y, island[j].x, island[j].y)));
				}
			}
			
			Collections.sort(weights, new Comparator<Pos>() {
				@Override
				public int compare(Pos o1, Pos o2) {
					return Double.compare(o1.weight, o2.weight);
				}
			});
			
			parent = new int[N];
			for(int i = 0;i < N; i++) {
				parent[i] = i;
			}
			double ans = 0;
			for(int i = 0; i < weights.size(); i++) {
				if(!isSameParent(weights.get(i).x, weights.get(i).y)) {
					union(weights.get(i).x, weights.get(i).y);
					ans = ans += weights.get(i).weight;
				}
			}
			System.out.printf("#%d %.0f\n", t, ans);
		}
	}
	private static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		if(x != y) {
			parent[y] = x;
		}
	}
	private static boolean isSameParent(int x, int y) {
		x = findParent(x);
		y = findParent(y);
		if(x == y) return true;
		else return false;
	}
	private static int findParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
	}
	private static double getWeight(long x, long y, long dx, long dy) {
		return E * Math.pow(Math.sqrt(Math.pow(dx-x, 2) + Math.pow(dy-y, 2)),2);
	}
}
