package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260_DFSvsBFS {
	static int N, M, V;
	static StringBuilder sb2;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		V = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		check = new boolean[N+1];
		sb2 = new StringBuilder();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for(int i = 1; i < N; i++) {
			Collections.sort(list.get(i));
		}
		dfs(V);
		System.out.println(sb2.toString().trim());
		for(int i = 0; i <= N; i++) {
			check[i] = false;
		}
		bfs(V);
	}
	static void bfs(int pos) {
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		queue.offer(pos);
		check[pos] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			
			for(int i = 0; i < list.get(current).size(); i++) {
				if(!check[list.get(current).get(i)]) {
					queue.offer(list.get(current).get(i));
					check[list.get(current).get(i)] = true;
				}
			}
		}
		System.out.print(sb.toString().trim());
	}
	static void dfs(int pos) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(pos);
		check[pos] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(check[current])
				sb2.append(current).append(" ");	
			
			for(int i = 0; i < list.get(current).size(); i++) {
				if(!check[list.get(current).get(i)]) {
					dfs(list.get(current).get(i));
				}
			}
		}
	}
}
