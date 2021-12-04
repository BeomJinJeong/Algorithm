package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2606_바이러스 {
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] check;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		check = new boolean[N + 1];
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		dfs(1);
		System.out.println(cnt - 1);
	}
	private static void dfs(int n) {
		if(check[n]) return;
		check[n] = true;
		int size = list.get(n).size();
		cnt++;
		
		for(int i = 0; i < size; i++) {
			int a = list.get(n).get(i);
			if(!check[a]) {
				dfs(a);
			}
		}
	}
}
