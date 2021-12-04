package com.ssafy.code.problem.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q9_서로소집합 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] repres;
	static int N, M, T;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sb = new StringBuilder();
			
			makeSet();
			
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				
				String cmd = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch(cmd) {
				case "0":
					union(a, b);
					break;
				case "1":
					a = find(a);
					b = find(b);
					if(a == b) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			System.out.println(Arrays.toString(repres));
			System.out.println("#" + t + " " + sb.toString());
		}
	}
	static void makeSet() {
		repres = new int[N + 1];
		for(int i = 1; i < repres.length; i++) {
			repres[i] = -1;	// 대표자 배열에 음소가 있으면 --> 그녀석이 대표자
		}
	}
	static int find(int a) {
		if(repres[a] < 0) {
			return a;
		} else {
			return repres[a] = find(repres[a]);
		}
	}
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b) {
			return false;
		} else {
			// a에 달린 식솔을 b에 넘겨주기
			repres[b] += repres[a];
			// 대표자 바꿔주기
			repres[a] = b;
			return true;
		}
	}
}
