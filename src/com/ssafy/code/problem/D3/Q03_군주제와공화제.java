package com.ssafy.code.problem.D3;

import java.util.Scanner;

public class Q03_군주제와공화제 {
	static int[][] arr;
	static int N;
	static double[][] enfluence;
	static char[] list;
	public static void main(String[] args) { // 다시
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			list = new char[N];
			arr = new int[N][3];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 3; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			enfluence = new double[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					double loSi = cal(i, j, arr[i][2]);
					enfluence[i][j] = (loSi < (double)arr[j][2]) ? 0 : loSi;
				}
			}
			cal2();
			for(int i = 0; i < N; i++) {				
				check(i);
			}
			System.out.print("#" + t);
			for(char a : list) {
				System.out.print(" " + a);
			}
			System.out.println();
		}
	}
	public static double cal(int i, int j, int si) {
		if(i == j) return 0;
		double loSi = (double)arr[i][2] / (double)((arr[i][0] - arr[j][0])*(arr[i][0] - arr[j][0]) + (arr[i][1] - arr[j][1]) * (arr[i][1] - arr[j][1]));
		return loSi;
	}
	public static void cal2() {
		for(int j = 0; j < N; j++) {
			double max = 0;
			int count = 0;
			double[] maxList = new double[N];
			for(int i = 0; i < N; i++) {
				if(enfluence[i][j] != 0.0) {
					count++;
					maxList[i] = enfluence[i][j];
				}
			}
			if(count == 0) list[j] = 'K';
			else {
				count = 0;
				for(int k = 0; k < N; k++) {
					max = Math.max(max, maxList[k]);
				}
				for(int k = 0; k < N; k++) {
					if(max == maxList[k]) {
						count++;
						list[j] = (char)(k+1+'0');
					}
				}
				if(count >= 2) list[j] = 'D';
			}
		}
		
	}
	static void check(int i) {
		if(list[i] == 'K' | list[i] == 'D') return;
		int j = Character.getNumericValue(list[i])-1;
		if(list[j] == 'K' | list[j] == 'D') return;
		else {
			check(j);
			list[i] = list[j];
		}
	}
}
