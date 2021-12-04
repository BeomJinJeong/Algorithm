package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q12_스도쿠검증_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int[][] arr = new int[9][9];
			int sum = 0;
			int result = 0;
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			boolean res = true;
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sum += arr[i][j];
				}
				if(sum != 45) {
					res = false;
					break;
				}
				sum = 0;
			}
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sum += arr[i][j];
				}
				if(sum != 45) {
					res = false;
					break;
				}
				sum = 0;	
			}
			for(int i = 0; i < 9; i+=3) {
				for(int j = 0; j < 9; j+=3) {
					
					for(int k = i; k < i+2; k++) {
						for(int l = j; l < j+2; l++) {
							sum += arr[k][l];
						}
						if(sum != 45) {
							res = false;
							break;
						}
						sum = 0;
					}
				}
			}
			result = res?1:0;
			System.out.println("#" + test_case + " " + result);
			
		}
		sc.close();
	}
}
