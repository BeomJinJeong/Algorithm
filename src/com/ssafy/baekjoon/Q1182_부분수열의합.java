package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1182_부분수열의합 {
	static int[] input;
	static boolean[] check;
	static int N, goal, count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		count = 0;
		input = new int[N];
		check = new boolean[N];
		
		String str = br.readLine();
		StringTokenizer st2 = new StringTokenizer(str);
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st2.nextToken());
		}
		generateSubSet(0);
		System.out.println(count);
		count = 0;
	}
	
	private static void generateSubSet(int cnt) {
		if(cnt == N) {
			int sum = 0, zero = 0;
			for(int i = 0; i < N; i++) {
				if(check[i]) {
					sum += input[i];
					zero++;
				}
			}
			if(sum==goal && zero > 0) count++;
			return;
		}
		check[cnt] = true;
		generateSubSet(cnt+1);
		check[cnt] = false;
		generateSubSet(cnt+1);
	}
}
