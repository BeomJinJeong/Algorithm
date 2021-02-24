package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q09_성적매기기 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int target = sc.nextInt();
			double[] temp = new double[N];
			int[] rank = new int[N];
			double max = 0;
			for(int i = 0; i < N; i++) {
				int a = sc.nextInt();
				temp[i] += a*0.35;
				a = sc.nextInt();
				temp[i] += a*0.45;
				a = sc.nextInt();
				temp[i] += a*0.2;
			}
			int count = 1;
			for(int j = 0; j < N; j++) {
				for(int i = 0; i < N; i++) {
					max = Math.max(max, temp[i]);
				}
				for(int k = 0; k < N; k++) {
					if(max == temp[k]) {
						rank[k] = count++;
						temp[k] = 0;
						max = 0;
						break;
					}
				}
			}
			int a = N/10;
			int b = rank[target-1]; 
			
			if ( 9*a < b && b <= 10*a ) System.out.println("#" + test_case + " D0");
			else if ( 8*a < b && b <= 9*a ) System.out.println("#" + test_case + " C-");
			else if ( 7*a < b && b <= 8*a ) System.out.println("#" + test_case + " C0");
			else if ( 6*a < b && b <= 7*a ) System.out.println("#" + test_case + " C+");
			else if ( 5*a < b && b <= 6*a ) System.out.println("#" + test_case + " B-");
			else if ( 4*a < b && b <= 5*a ) System.out.println("#" + test_case + " B0");
			else if ( 3*a < b && b <= 4*a ) System.out.println("#" + test_case + " B+");
			else if ( 2*a < b && b <= 3*a ) System.out.println("#" + test_case + " A-");
			else if ( a < b && b <= 2*a ) System.out.println("#" + test_case + " A0");
			else if( b <= a ) System.out.println("#" + test_case + " A+");
			
		}
		sc.close();
	}
}
