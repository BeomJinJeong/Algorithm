package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q15_숫자배열회전 {
	static int N;
	static String[][] result;
	public static void main(String[] args) {
		Q15_숫자배열회전 q = new Q15_숫자배열회전();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			result = new String[N][3];
			int[][] temp2 = new int[N][N];
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			temp2 = q.cir90(arr, N, 0);
			temp2 = q.cir90(temp2, N, 1);
			temp2 = q.cir90(temp2, N, 2);
			
			System.out.println("#" + t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 3; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
	int[][] cir90(int[][] arr, int N, int c) {
		int pos = 0;
		int[][] temp = new int[N][N];
		
		for(int j = 0; j < N; j++) {
			for(int i = N-1; i >= 0; i--) {
				temp[j][pos++] = arr[i][j];
			}
			pos = 0;
		}
		String str = "";
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				str += String.valueOf(temp[i][j]);
			}
			result[i][c] = str;
			str = "";
		}
		return temp;
	}
}
