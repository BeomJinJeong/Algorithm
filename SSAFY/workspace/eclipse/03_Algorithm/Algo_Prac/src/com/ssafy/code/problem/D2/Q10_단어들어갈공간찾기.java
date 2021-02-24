package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q10_단어들어갈공간찾기 { 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int test_case = 0; test_case < T; test_case++) {
			int N = sc.nextInt();
			int word = sc.nextInt();
			int count = 0;

			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <= N - word; j++) {
					
					if(arr[i][j] == 0) continue;
					
					boolean isBlock = false;
					for(int k = 1; k < word; k++) {
						if( arr[i][j + k] == 0 || j + k >= N) {
							isBlock = true;
							break;
						}
					}
					
					if(isBlock) continue;
					
					if( ( j - 1 < 0  || arr[i][j-1] == 0) && ((j+word >= N) || (arr[i][j + word] == 0 ))) {
						count++;
					}
				}
			}
			
			for(int i = 0; i <= N - word; i++) {
				for(int j = 0; j < N; j++) {
					
					if(arr[i][j] == 0) continue;
					
					boolean isBlock = false;
					for(int k = 1; k < word; k++) {
						if( arr[i + k][j] == 0 || i + k >= N) {
							isBlock = true;
							break;
						}
					}
					
					if(isBlock) continue;
					
					if( ( i-1 < 0 || arr[i-1][j] == 0 ) && ((i + word >= N) || (arr[i + word][j] == 0 ))) {
						count++;
					}
				}
			}
			System.out.println("#" + test_case + " " + count);
			
		}
		sc.close();
	}
}
