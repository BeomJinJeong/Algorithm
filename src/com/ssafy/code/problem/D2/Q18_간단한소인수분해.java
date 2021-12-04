package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q18_간단한소인수분해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] num = {2, 3, 5, 7, 11};
			int index = 0;
			for(int i = 0; i <= 10000; i++) {
				if(N % num[index] !=0) {
					num[index] = i;
					i = -1;
					if(++index >= 5) break;
					continue;
				} else if(N==1) break;
				else N = N/num[index];
			}
			System.out.print("#" + t);
			for(int result : num) {
				System.out.print(" " + result);
			}
			System.out.println();
		}
		sc.close();
	}
}
