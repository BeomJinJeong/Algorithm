package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q3052_나머지 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < 10; i++) 
			set.add(Integer.parseInt(br.readLine()) % 42);
		System.out.println(set.size());
	}
}
