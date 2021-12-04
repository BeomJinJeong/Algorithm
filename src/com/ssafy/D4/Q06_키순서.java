package com.ssafy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q06_키순서 {
	static int[][] comp;
	static int bigger, shorter;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			comp = new int[N + 1][N + 1];
			
			StringTokenizer st = null;
			for(int i = 0;i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				comp[s][l] = 1;
			}
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				bigger = shorter = 0;
				tbfs(i, N);
				lbfs(i, N);
				if(bigger + shorter == N - 1) ans++;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	private static void tbfs(int start, int N) {
		boolean[] check = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 1; i <= N; i++) {
				if(!check[i] && comp[cur][i] == 1) {
					q.add(i);
					check[i] = true;
					bigger++;
				}
			}
		}
	}
	private static void lbfs(int start, int N) {
		boolean[] check = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i = 1; i <= N; i++) {
				if(!check[i] && comp[i][cur] == 1) {
					q.add(i);
					check[i] = true;
					shorter++;
				}
			}
		}
	}
}
