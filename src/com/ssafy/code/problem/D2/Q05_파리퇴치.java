package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q05_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = 0;
			int count = 0;
			int[][] area = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					area[i][j] = sc.nextInt();
				}
			}
			
			
			for(int i = 0; i <= N - M; i++) {
				for(int l = 0; l <= N - M; l++) {
					for(int k = i; k < i + M; k++) {
						for(int j = l; j < l + M; j++) {
							count += area[k][j];
						}
					}
					max = Math.max(max, count);
					count = 0;
				}
			}
			System.out.println("#" + test_case + " " + max);
		}	
		sc.close();
	}
}
