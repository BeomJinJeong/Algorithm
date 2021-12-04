package com.ssafy.D2;

import java.util.Scanner;

public class Q01_달팽이숫자 {
	
	static int[] x = {1, 0, -1, 0};
	static int[] y = {0, 1, 0, -1};
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int[][] arr;
	static int count = 1;
	static boolean[][] check = new boolean[N][N];
	static Q01_달팽이숫자 q = new Q01_달팽이숫자();
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			q.count(0, 0, 0);
			
			System.out.println("#" + t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			count = 1;
		}
	}
	public void back(int i, int j, int dir) {
		switch(dir) {
		case 0: 
			j -= 1;
			i += 1;
			dir++;
			count(i, j, dir);
			break;
		case 1:
			i -= 1;
			j -= 1;
			dir++;
			count(i, j, dir);
			break;
		case 2:
			j += 1;
			i -= 1;
			dir++;
			count(i, j, dir);
			break;
		case 3:
			i += 1;
			j += 1;
			dir++;
			count(i, j, dir);
			break;
		}
	}
	void count(int i, int j, int dir) {
		if(count > N*N) return;
		dir = dir%4;
		if(j >= N | j < 0 | i < 0 | i >= N ) {
			q.back(i, j, dir);
		} else if(arr[i][j]!=0) {
			q.back(i, j, dir);
		} else {
			arr[i][j] = count;
			count++;
			count(i+y[dir], j+x[dir], dir);			
		}
	}
}
