package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16953_A에서B {
	static long N, To;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		To = Integer.parseInt(st.nextToken());
		bfs();
	}
	private static void bfs() {
		Queue<long[]> q = new LinkedList<>();
		q.add(new long[] {N, 1});
		
		while(!q.isEmpty()) {
			long[] cur = q.poll();
			if(cur[0] == To) {
				System.out.println(cur[1]);
				return;
			}
			if(cur[0] >= 1 && cur[0] < Math.pow(10, 9)) {				
				q.add(new long[] {cur[0] * 2, cur[1] + 1});
				q.add(new long[] {cur[0] * 10 + 1, cur[1] + 1});
			}
		}
		System.out.println(-1);
	}
}
