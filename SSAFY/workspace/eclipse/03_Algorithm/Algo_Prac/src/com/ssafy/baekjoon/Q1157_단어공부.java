package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1157_단어공부 {
	public static void main(String[] args) throws Exception {
		String sample = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int[] sample2 = new int[26];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toUpperCase().toCharArray(); // 대문자로 변환 후, 배열로 저장
		int max = -1, count = 0;
		for(int i = 0; i < str.length; i++) {
			sample2[sample.indexOf(str[i])]++;
		}
		for(int i = 0; i < 26; i++) {	// 가장 많이 사용된 알파벳 갯수 알아보기
			max = Math.max(sample2[i], max);
		}
		for(int i = 0; i < 26; i++) { // MAX 가 두개 이상일 경우 ? 출력하고 종료
			if(max == sample2[i]) count++;
			if(count >= 2) {
				System.out.println("?");
				return;
			}
		}
		for(int i = 0; i < 26; i++) { // 많이 사용된 알파벳 나타내기
			if(max == sample2[i]) {
				System.out.println(sample.toCharArray()[i]);
				break;
			}
		}
	}
}
