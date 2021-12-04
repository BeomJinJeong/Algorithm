package com.ssafy.code.problem.D3;

import java.util.Scanner;
import java.util.Stack;

public class Q05_문자열의거울상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t = 1; t <= T; t++) {
			char[] arr = sc.nextLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			
			for(int i = 0 ; i < arr.length; i++) {
				switch(arr[i]) {
				case 'b':
					arr[i] = 'd';
					break;
				case 'd':
					arr[i] = 'b';
					break;
				case 'q':
					arr[i] = 'p';
					break;
				case 'p':
					arr[i] = 'q';
					break;
				}
				stack.push(arr[i]);
			}
			StringBuilder st = new StringBuilder();
			int size = stack.size();
			for(int i = 0; i < size; i++) {
				st.append(stack.pop());
			}
			System.out.print("#" + t + " ");
			System.out.println(st.toString());
		}
	}
}
