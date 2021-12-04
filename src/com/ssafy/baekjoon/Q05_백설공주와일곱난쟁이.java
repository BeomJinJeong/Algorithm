package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q05_백설공주와일곱난쟁이 {
	static int[] numbers, input;
	static int N;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numbers = new int[7];
		input = new int[9];
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());			
			input[i] = Integer.parseInt(st.nextToken());
		}
		comb(0, 0);
	}
	private static void comb(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int a : numbers) {
				sum += a;
			}
			if(sum == 100) {
				Arrays.sort(numbers);
				for(int a : numbers) {
					System.out.println(a);
				}
			}
			return;
		}
		for(int i = start; i < 9; i++) {
			numbers[cnt] = input[i];  
			comb(cnt+1, i+1);
		}
	}
}
