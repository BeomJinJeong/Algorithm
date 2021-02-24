package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q08_중간평균값 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int test_case = 1; test_case <= T; test_case++ ) {
			int[] arr = new int[10];
			double max = 0;
			double min = 10000;
			double sum = 0;
			
            for(int i = 0; i < 10; i++){
            	arr[i] = sc.nextInt();
                max = Math.max(max, (double)arr[i]);
				min = Math.min(min, (double)arr[i]);
				sum += arr[i];
            }
			System.out.println("#" + test_case + " " + Math.round((sum - min - max)/8.0));
		}
		sc.close();
	}
}
