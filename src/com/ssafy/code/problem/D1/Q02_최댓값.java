package com.ssafy.code.problem.D1;
import java.util.Scanner;

public class Q02_최댓값 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		int[] arr = new int[10];
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int max = 0;
			for(int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
				
				if(max < arr[i]) {
					max = arr[i];
				}
			}
			System.out.println("#" + test_case + " " + max);
			max = 0;
		}
		sc.close();
	}

}
