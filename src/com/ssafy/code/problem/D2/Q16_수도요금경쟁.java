package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q16_수도요금경쟁 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int p, q, r, s, w;
			p = sc.nextInt();
			q = sc.nextInt();
			r = sc.nextInt();
			s = sc.nextInt();
			w = sc.nextInt();
			
			int A = p * w;
			int B = 0; 
			if(w <= r) B = q; 
			else B = q + s*(w-r);
			int result = Math.min(A, B);
			System.out.println("#" + t + " " + result);
		}
		sc.close();
	}
}
