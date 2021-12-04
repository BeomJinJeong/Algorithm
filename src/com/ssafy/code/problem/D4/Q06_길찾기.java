package com.ssafy.code.problem.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q06_길찾기 {
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] check;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			check = new boolean[100];
			list = new ArrayList<>();
			for(int i = 0; i < 100; i ++) {
				list.add(new ArrayList<>());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);
			}
			dfs(0);
			System.out.println("#" + t + " " + (flag ? 1 : 0));
			flag = false;
		}
	}
	private static void dfs(int n) {
		if(check[n]) return;
		check[n] = true;
		int size = list.get(n).size();
		if(n == 99) {
			flag = true;
			return;
		}
		
		for(int i = 0; i < size; i++) {
			int a = list.get(n).get(i);
			if(!check[a]) {
				dfs(a);
			}
		}
	}
}
