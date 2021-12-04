package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q1316_그룹단어체커 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		Stack<String> stack = new Stack<>();
		Set<String> set = new HashSet<>();
		outer : for(int i = 0; i < N; i++) {
			String[] target = br.readLine().split("");
			for(int j = 0; j < target.length; j++) {
				if(stack.isEmpty()) stack.push(target[j]);
				else {
					if(stack.peek().equals(target[j])) continue;
					stack.push(target[j]);
				}
			}
			for(int j = 0; j < stack.size(); j++) {
				if(set.contains(stack.get(j))) {
					set.clear();
					stack.clear();
					continue outer;
				}
				set.add(stack.get(j));
			}
			ans++;
			set.clear();
			stack.clear();
		}
		System.out.println(ans);
	}

}
