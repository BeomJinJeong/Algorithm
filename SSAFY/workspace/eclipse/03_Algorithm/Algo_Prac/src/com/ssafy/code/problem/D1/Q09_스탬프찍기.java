package com.ssafy.code.problem.D1;

import java.util.Scanner;

public class Q09_스탬프찍기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			System.out.print("#");
		}
		sc.close();
	}
}
