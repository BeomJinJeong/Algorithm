package com.ssafy.code.problem.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q12_힙 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = null;
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			// 최대힙 - 내림차순 --> 우선순위 큐의 정렬 방향을 바꿔주자.
			PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				if(st.nextToken().equals("1")) {
					q.offer(Integer.parseInt(st.nextToken()));
				} else {
					// q에서 빼려는데 없으면  --> -1 반환
					if(q.size() == 0) sb.append(-1).append(" ");
					else sb.append(q.poll()).append(" ");
				}
			}
			System.out.println(sb);
		}
	}
}
