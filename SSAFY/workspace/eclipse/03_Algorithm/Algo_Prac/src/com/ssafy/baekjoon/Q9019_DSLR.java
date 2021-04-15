package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9019_DSLR {
	static class tmp {
		int a;
		String s;
		public tmp(int a, String s) {
			super();
			this.a = a;
			this.s = s;
		}
	}
	static int str1, str2;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			str1 = Integer.parseInt(st.nextToken());
			str2 = Integer.parseInt(st.nextToken());
			solve(str1, str2);		
		}
	}
	private static void solve(int a, int b) {
		Queue<tmp> q = new LinkedList<>();
		q.add(new tmp(a, ""));
		boolean[] check = new boolean[10000];
		
		while(!q.isEmpty()) {
			tmp cur = q.poll();
			if(cur.a == b) {
				System.out.println(cur.s);
				return;
			}
			int f1 = func1(cur.a);
			int f2 = func2(cur.a);
			int f3 = func3(cur.a);
			int f4 = func4(cur.a);
			if(!check[f1]) {
				q.add(new tmp(f1, cur.s + "D"));
				check[f1] = true;
			}
			if(!check[f2]) {
				q.add(new tmp(f2, cur.s + "S"));
				check[f2] = true;
			}
			if(!check[f3]) {
				q.add(new tmp(f3, cur.s + "L"));
				check[f3] = true;
			}
			if(!check[f4]) {
				q.add(new tmp(f4, cur.s + "R"));
				check[f4] = true;
			}
		}
	}
	private static int func1(int a) {
		return (2 * a) % 10000;
	}
	private static int func2(int a) {
		return a - 1 < 0 ? a - 1 + 10000 : a - 1;
	}
	private static int func3(int a) {
		int b = a / 1000;
		return (a - (b * 1000)) * 10 + b;
	}
	private static int func4(int a) {
		int b = a % 10;
		return (b * 1000) + (a / 10);
	}
}
