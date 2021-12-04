package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1725_히스토그램 {	// 시간초과
	static int[] arr;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 2];
		for(int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		solve(N);
	}
	private static void solve(int N) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		
		for(int i = 1; i <= N + 1; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				int height = arr[stack.peek()];
				stack.pop();
				int width = i - stack.peek() - 1;
				ans = Math.max(ans, width * height);
			}
			stack.push(i);
		}
		System.out.println(ans);
	}
}
