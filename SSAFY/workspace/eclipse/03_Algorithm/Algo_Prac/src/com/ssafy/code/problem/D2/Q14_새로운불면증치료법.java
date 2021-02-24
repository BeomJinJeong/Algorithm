package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q14_새로운불면증치료법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			
			int N = sc.nextInt(); 
			int a = N;	// 처음 들어온 값
			int[] check = new int[10]; // 각 자리수 체크할 배열
			int temp = 0;	// 나머지로 자릿수 구할 때 사용
			int multiple = 1;	// 배수
			
			while(true) {
				int sum = 0, b = N;	// 체크 배열의 합을 구할 sum, N을 계속 나눈 몫 b
				while(true) {
					temp = b % 10; 
					check[temp] = 1;
					b = b / 10;
					if(b == 0) break;
				}
				for(int i = 0; i < 10; i++) {
					sum += check[i];
				}
				if(sum == 10) break;
				N = a*(++multiple);
			}
			System.out.println("#" + t + " " + N);
		}
		sc.close();
	}
}
