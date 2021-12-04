package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q17_두개의문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] numbers1 = new int[N];
			int[] numbers2 = new int[M];
			
			for(int i = 0; i < N; i++) {
				numbers1[i] = sc.nextInt();
			}
			for(int i = 0; i < M; i++) {
				numbers2[i] = sc.nextInt();
			}
			int sum = 0;
			for(int i = 0; i < (N>M?N-M+1:M-N+1); i++) {
				int count = i;	
				int temp = 0;
				for(int j = 0; j < (N>M?M:N); j++) {
					temp += (N>M?numbers1[count++]*numbers2[j] : numbers2[count++]*numbers1[j]);
				}
				sum = Math.max(sum, temp);
			}
			System.out.println("#" + t + " " + sum);
		}
		sc.close();
	}
}
