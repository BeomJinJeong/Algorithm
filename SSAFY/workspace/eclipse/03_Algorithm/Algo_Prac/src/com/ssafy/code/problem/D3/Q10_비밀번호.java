package com.ssafy.code.problem.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q10_비밀번호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			Stack<Integer> stack = new Stack<>();
			String[] temp = st.nextToken().split("");
			int[] arr = new int[N];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(temp[i]);
			}
			
			for(int i = 0; i < arr.length; i++) {
				if(!stack.isEmpty()) {
					if(stack.peek() == arr[i]) {
						stack.pop();
						continue;
					}
				}
				stack.push(arr[i]);
			}
			System.out.print("#" + t + " ");
			for(int i = 0; i < stack.size(); i++) {
				System.out.print(stack.get(i));
			}
			System.out.println();
		}
	}
}
