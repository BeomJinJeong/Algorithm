package com.ssafy.code.problem.D2;

import java.util.Arrays;
import java.util.Scanner;

public class Q12_스도쿠검증 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int[][] arr = new int[9][9];
			int[] check = new int[9];
			int result = 0;
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			Arrays.fill(check, 1);
			boolean res = true;
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					check[arr[i][j]-1]--;
//					sum += arr[i][j];
				}
				for(int j = 0; j < check.length; j++) {
					if(check[j]==-1) {
						res = false;
						break;
					}
				}
				if(!res) break;
				Arrays.fill(check, 1);				
			}
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					check[arr[j][i]-1]--;
				}
				for(int j = 0; j < check.length; j++) {
					if(check[j]==-1) {
						res = false;
						break;
					}
				}
				if(!res) break;
				Arrays.fill(check, 1);	
			}
			for(int i = 0; i < 9; i+=3) {
				for(int j = 0; j < 9; j+=3) {
					
					for(int k = i; k < i+2; k++) {
						for(int l = j; l < j+2; l++) {
							check[arr[k][l]-1]--;
						}
					}
					for(int k = 0; k < check.length; k++) {
						if(check[k]==-1) {
							res = false;
							break;
						}
					}
					if(!res) break;
					Arrays.fill(check, 1);
				}
			}
			result = res?1:0;
			System.out.println("#" + test_case + " " + result);
			
		}
		sc.close();
	}
}
