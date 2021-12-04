package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09_찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tLength = text.length, pLength = pattern.length;
		
		int[] fail = new int[pLength];
		for(int i = 1, j = 0; i < pLength; i++) {
			while( j > 0 && pattern[i] != pattern[j] ) {
				j = fail[j - 1];
			}
			if(pattern[i] == pattern[j]) {
				fail[i] = ++j;
			}
		}
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0, j = 0; i < tLength; i++) {
			while(j > 0 && text[i] != pattern[j]) {
				j = fail[j - 1];
			}
			if(text[i] == pattern[j]) {
				if(j == pLength - 1) {
					cnt++;
					sb.append(i - pLength + 2).append(" ");
					j = fail[j];
				} else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
}
