package com.ssafy.code.problem.D1;

import java.util.Scanner;

public class Q10_서랍의비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pw = sc.nextInt();
		int start = sc.nextInt();
		System.out.println(pw-start+1);
		sc.close();
	}
}
