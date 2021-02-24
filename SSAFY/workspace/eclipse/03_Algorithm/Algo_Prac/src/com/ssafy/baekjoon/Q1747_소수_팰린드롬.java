package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1747_소수_팰린드롬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pal(N);
	}
	public static boolean getNum(int m) {
		if(m == 1) return false;
		for(int j = 2; j < m; j++) 
			if(m % j == 0) return false;
		return true;
	}
	public static void pal(int n) {
		outer : for(int i = n; i < Integer.MAX_VALUE; i++) {
			String str = String.valueOf(i);
			int start = 0;
			int end = str.length() - 1;
			while(start <= end) {
				if(str.charAt(start) != str.charAt(end)) {
					continue outer;
				}
				start++;
				end--;
			}
			if(getNum(i)) {
				System.out.println(i);
				return;
			} else continue;
		}
	}
}
