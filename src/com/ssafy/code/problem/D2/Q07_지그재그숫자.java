package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q07_지그재그숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(sc.nextLine());
			int count = 1;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(count % 2 == 1) sum += count++;
				else sum -= count++;
			}
			System.out.println("#" + test_case + " " + sum);
		}
		sc.close();
	}
}
