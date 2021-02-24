package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q02_간단한369 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String[] str = new String[N];
		for(int i = 0; i < N; i++) {
			boolean contain = false;
			int count = 0;
			str[i] = String.valueOf(i+1);
			String[] temp = str[i].split("");
			for(int k = 0; k < temp.length; k++) {
				if(temp[k].contains("3") || temp[k].contains("6") || temp[k].contains("9")) { count++; contain = true; }	
			}
			if(contain) {
				for(int j = 0; j < count; j++) {
					System.out.print("-");
				}
			} else System.out.print(str[i]);
			System.out.print(" ");
		}
		sc.close();
	}
}
