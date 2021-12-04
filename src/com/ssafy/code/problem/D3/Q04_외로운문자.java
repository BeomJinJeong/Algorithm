package com.ssafy.code.problem.D3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Q04_외로운문자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t <= T; t++) {
			HashSet<Character> set = new HashSet<>();
			char[] arr = sc.nextLine().toCharArray();
			
			for(int i = 0; i < arr.length; i++) {
				if(set.contains(arr[i])) set.remove(arr[i]);
				else set.add(arr[i]);
			}
			if(set.size()==0) System.out.println("#" + t + " Good");
			else {
				StringBuilder sb = new StringBuilder();
				for(char a : set) {
					sb.append(a);
				}
				char[] temp = sb.toString().toCharArray();
				Arrays.sort(temp);
				System.out.print("#" + t + " ");
				for(char a : temp) {
					System.out.print(a);
				}
				System.out.println();
			}
		}
	}
}
