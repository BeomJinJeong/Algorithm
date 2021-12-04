package com.ssafy.code.problem.D3;

import java.util.Scanner;

public class Q02_순열1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] check = new int[N];
			boolean result = true;
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				check[arr[i]-1]++;
			}
			
			for(int i = 0; i < N; i++) {
				if(check[i] == 2 | check[i] == 0) {
					result = false;
					break;
				}
			}
			
			System.out.println("#" + t + " " + (result ? "Yes" : "No"));
		}
		sc.close();
	}
}
