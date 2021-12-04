package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q17413_단어뒤집기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		boolean check = false;
		for(int i = 0; i < arr.length; i++) {
			if(!check) {
				if(arr[i] == '<') {
					int size = stack.size();
					for(int j = 0; j < size; j++) {
						System.out.print(stack.pop());
					}
					check = true;
					sb.append(arr[i]);
					continue;
				} else if(arr[i] == ' ') {
					int size = stack.size();
					for(int j = 0; j < size; j++) {
						System.out.print(stack.pop());
					}
					System.out.print(" ");
				} else {
					stack.push(arr[i]);
				}
			} else {
				if(arr[i] == '>') {
					check = false;
					sb.append(arr[i]);
					System.out.print(sb);
					sb.delete(0, sb.length());
				} else sb.append(arr[i]);
			}
		}
		int size = stack.size();
		for(int i = 0; i < size; i++) {
			System.out.print(stack.pop());
		}
	}
}
