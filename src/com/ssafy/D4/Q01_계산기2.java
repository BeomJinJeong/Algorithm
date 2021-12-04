package com.ssafy.D4;

import java.util.Scanner;
import java.util.Stack;

public class Q01_계산기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(sc.nextLine());
			char[] arr = sc.nextLine().toCharArray();
			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			Stack<Integer> stack2 = new Stack<>();
			
			for(int i = 0; i < N; i++) {
				if(arr[i] == '*') stack.push(arr[i]);
				else if(arr[i] == '+') {
					if(!stack.isEmpty()) {
						sb.append(stack.pop());
						i--;
						continue;
					}
					stack.push(arr[i]);
				} else sb.append(arr[i]);
			}
			int size = stack.size();
			for(int i = 0; i < size; i++) sb.append(stack.pop());
			for(int i = 0; i < N; i++) arr[i] = sb.charAt(i);
			for(int i = 0; i < N; i++) {
				if(arr[i] == '*') {
					int a = stack2.pop();
					int b = stack2.pop();
					stack2.push(a*b);
				} else if (arr[i] == '+') {
					int a = stack2.pop();
					int b = stack2.pop();
					stack2.push(a+b);
				} else stack2.push(arr[i]-'0');
			}
			int result = stack2.pop();
			System.out.println("#" + t + " " + result);
		}
		sc.close();
	}
}
