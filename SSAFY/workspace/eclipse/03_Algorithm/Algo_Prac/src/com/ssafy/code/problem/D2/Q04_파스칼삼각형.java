package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q04_파스칼삼각형 {	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(sc.nextLine());
			int[] arr = new int[N];
			arr[0] = 1;
			System.out.println("#" + test_case);
			for(int i = 0; i < N; i++) {
				for(int j = i; j > 0; j--) {
					arr[j] = arr[j] + arr[j-1];
				}
				for(int k = 0; k <= i; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println("");
			}
		}
		sc.close();
	}
}
