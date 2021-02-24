package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q3568_iSharp {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Character> stack = new Stack<>();
		Queue<Character> var = new LinkedList<>();
		
		String first = st.nextToken();
		int cnt = st.countTokens();
		for(int i = 0; i < cnt; i++) {			
			StringBuilder sb = new StringBuilder();
			sb.append(first);
			char[] str = st.nextToken().toCharArray();
			for(int j = 0; j < str.length - 1; j++) {
				if(str[j] == '&' || str[j] == '*' || str[j] == '[' || str[j] == ']') {
					if(str[j] == ']') {
						char temp = stack.pop();
						stack.push(str[j]);
						stack.push(temp);
						continue;
					}
					stack.push(str[j]);
				} else {
					var.offer(str[j]);
				}
			}
			int size = stack.size();
			for(int j = 0; j < size; j++) {
				sb.append(stack.pop());
			}
			sb.append(" ");
			size = var.size();
			for(int j = 0; j < size; j++) {
				sb.append(var.poll());
			}
			sb.append(";");
			System.out.println(sb);
		}
	}
}
