package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697_숨바꼭질 {
	static int N, K;
	static int[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		check = new int[100001];
		
		if(N == K) {
			System.out.println("0");
			return;
		} else {
			bfs(N);
		}
		
		
	}
	private static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		check[n] = 1;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int i = 0; i < 3; i++) {
				int next;
				
				if(i == 0) next = temp + 1;
				else if(i == 1) next = temp - 1;
				else next = temp * 2;
				
				if(next == K) {
					System.out.println(check[temp]);
					return;
				}
				
				if (next >= 0 && next < check.length && check[next] == 0) {
                    queue.add(next);
                    check[next] = check[temp] + 1;
                }
			}
		}
	}
}
