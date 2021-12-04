package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q11_시각덧셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int test_case = 1; test_case < T; test_case++) {
			int[] arr = new int[4];
			int hou = 0, min = 0;
			for(int i = 0; i < 4; i++) {
				arr[i] = sc.nextInt();
				if(i%2 == 0) hou += arr[i];
				else min += arr[i];
			}
			if(min >= 60) {
				hou++;
				min -= 60;
			}
			if(hou >= 13) hou -= 12;
			
			System.out.println("#" + test_case + " " + hou + " " + min);
		}
		sc.close();
	}
}
