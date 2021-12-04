package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q16916_부분문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String part = br.readLine();
		
		String start = part.substring(0, 1);
		outer : for(int i = 0; i < str.length(); i++) {
			if(str.subSequence(i, i + 1).equals(start)) {
				for(int j = 1; j < part.length(); j++) {
					if(!str.substring(i + j, i + j + 1).equals(part.substring(j, j + 1))) {
						continue outer;
					}
				}
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}
}
