package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2941_크로아티아알파벳 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] word = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="}; 
		String input = br.readLine().trim();
		for(int i=0; i<word.length; i++) { 
			if(input.contains(word[i])) { 
				input = input.replaceAll(word[i], "*");
			}
		}
		System.out.println(input.length());
	}
}
