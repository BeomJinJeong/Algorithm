package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9935_문자열폭발 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		String bomb = br.readLine();
		
		Stack<String> stack = new Stack<>();
		StringBuilder strSb = new StringBuilder();
		for(int i = 0; i < str.length; i++) {
			stack.push(str[i]);
			
			if(stack.size() >= bomb.length()) {
				boolean check = true;
				
				for(int j = stack.size() - bomb.length(), idx = 0; j < stack.size(); j++, idx++) {
					if(!stack.get(j).equals(bomb.subSequence(idx, idx + 1))) {
						check = false;
						break;
					}
				}
				
				if(check) {
					for(int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		String ans;
		if(stack.size() == 0) ans = "FRULA";
		else {
			for(int i = 0; i < stack.size(); i++) {
				strSb.append(stack.get(i));
			}
			ans = strSb.toString();
		}
		System.out.println(ans);
	}
}
