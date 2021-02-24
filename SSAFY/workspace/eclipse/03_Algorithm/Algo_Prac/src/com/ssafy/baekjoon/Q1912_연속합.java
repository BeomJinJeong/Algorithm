package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1912_연속합 {
	static int C, N, sum = 0;
	static int[] numbers, result;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		result = new int[2];
		check = new boolean[N];		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		permutation(0, 0);
	}
	static void permutation(int cnt, int start) {
		if(cnt == C) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i = start; i < N; i++) {
			if(check[i]) continue;
			
			result[cnt] = numbers[i];
			check[i] = true;
			
			permutation(cnt+1, i+1);
			check[i] = false;
		}
		
	}
}
