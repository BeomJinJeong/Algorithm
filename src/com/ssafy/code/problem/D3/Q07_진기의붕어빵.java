package com.ssafy.code.problem.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q07_진기의붕어빵 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> q = new PriorityQueue<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int bread = 0;
			int time = 0;
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			while(true) {
				if(q.isEmpty()) {
					sb.append("Possible");
					break;
				}
				if(q.peek() != time) {
					time++;
				}
				if(time % M == 0) bread += K;
				if(q.peek() == 0) {
					sb.append("Impossible");
					break;					
				}
				if(time == q.peek()) {
					if(bread == 0) {
						sb.append("Impossible");
						break;
					} else {
						bread--;
						q.poll();
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
