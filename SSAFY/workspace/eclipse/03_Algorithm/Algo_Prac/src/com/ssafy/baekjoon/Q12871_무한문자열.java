package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q12871_무한문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int std = str1.length() * str2.length();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for(int i = 0; i < std / str1.length(); i++) {
			sb1.append(str1);
		}
		for(int i = 0; i < std / str2.length(); i++) {
			sb2.append(str2);
		}
		if(sb1.toString().equals(sb2.toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
