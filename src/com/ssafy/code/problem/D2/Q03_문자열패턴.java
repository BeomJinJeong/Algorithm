package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q03_문자열패턴 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			String str = sc.nextLine();
			int answer = 0;
			for(int i = 1; i <= 10; i++) {
				String temp1 = str.substring(0, i);
				String temp2 = str.substring(i, 2*i);
				if(temp1.equals(temp2))
					answer = i;
			}
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}