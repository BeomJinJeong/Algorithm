package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2644_촌수계산 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean result = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken().trim());
		st = new StringTokenizer(br.readLine());
		
		int findFrom = Integer.parseInt(st.nextToken());
		int findTo = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		
		for(int i = 0; i <= T; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			list.get(X).add(Y);
			list.get(Y).add(X);
		}
		boolean[] check = new boolean[T+1];
		dfs(check, findFrom, findTo, 0);
		if(!result) System.out.println("-1");
	}
	public static void dfs(boolean[] check, int findFrom, int findTo, int cnt) {
		check[findFrom] = true;
		for(int a : list.get(findFrom)) {
			if(!check[a]) {
				if(a == findTo) {
					System.out.println(cnt+1);
					result = true;
					return;
				}
				dfs(check, a, findTo, cnt+1);
			}
		}
	}
	
}
