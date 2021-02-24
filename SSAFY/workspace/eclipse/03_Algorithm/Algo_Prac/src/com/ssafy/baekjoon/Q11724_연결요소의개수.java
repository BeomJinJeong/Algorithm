package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11724_연결요소의개수 {
	static ArrayList<ArrayList<Integer>> list;
	static int N, M, cnt;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new boolean[N + 1];
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for(int i = 1; i <= N; i++) {
			if(dfs(i)) cnt++;
		}
		System.out.println(cnt);
	}
	public static boolean dfs(int i) {
		if(check[i]) return false;
		int size = list.get(i).size();
		check[i] = true;
		for(int k = 0; k < size; k++) {
			if(!check[list.get(i).get(k)]) {
				dfs(list.get(i).get(k));
				check[list.get(i).get(k)] = true;
			}
		}
		return true;
	}
}
