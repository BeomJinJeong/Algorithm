package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q02_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(n);
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int count = n - 1;
		while(count >= 0) {
			if(stack.isEmpty()) stack.push(arr[count]);
			else if(arr[count] < stack.peek()) {
				stack.push(arr[count]);
			} else if (arr[count] == stack.peek()) {
				for(int i = n-1; i >= 0; i--) {
					if(arr[i] == arr[count]) {
						arr[i] = count + 1;
						break;
					}
				}
			} else {
				int a = stack.pop();
				for(int i = 0; i < n; i++) {
					if(a == arr[i]) {
						arr[i] = count + 1;
						break;
					}
				}
				continue;
			}
			count--;
		}
		int size = stack.size();
		for(int i = 0; i <size; i++) {
			int b = stack.pop();
			for(int j = 0; j < n; j++) {
				if(b==arr[j]) {
					arr[j] = 0;
					break;
				}
			}
		}
		for(int a : arr) {
			System.out.print(a + " ");
		}
	}
}
