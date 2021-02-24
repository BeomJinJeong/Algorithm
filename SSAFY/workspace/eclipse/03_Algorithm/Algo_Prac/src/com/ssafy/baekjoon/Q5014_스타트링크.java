package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014_스타트링크 {
	static int F, S, G, U, D;
	static Queue<Integer> queue;
	static int[] building;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		building = new int[F + 1];
		bfs(S);
	}
	static void bfs(int pos) {
		queue.offer(pos);
		building[pos] = 1;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(current == G) {
				System.out.println(building[current]-1);
				return;
			}
			
			if(current + U <= F) {
				if(building[current + U] == 0) {
					building[current + U] = building[current] + 1;
					queue.offer(current + U);
				}
			}
			if(current - D > 0) {
				if(building[current - D] == 0) {
					building[current - D] = building[current] + 1;
					queue.offer(current - D);
				}
			}
		}
		System.out.println("use the stairs");
		return;
	}
}
