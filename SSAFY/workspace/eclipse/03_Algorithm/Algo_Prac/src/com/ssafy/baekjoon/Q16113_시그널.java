package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q16113_시그널 { // 계속..
	static String t1 = "#####";
	static String t2 = "#...#";
	static String t3 = "#.###";
	static String t4 = "#.#.#";
	static String t5 = "###.#";
	static String t6 = "###..";
	static String t7 = "..#..";
	static String t8 = "#....";
	static String[] str = {"#####", t2, t3, t4, t5, t6, t7, t8};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int wall = N / 5;
		char[][] word = new char[5][wall];
		char[] str = br.readLine().toCharArray();
		int cnt = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < wall; j++) {
				word[i][j] = str[cnt++];
			}
		}
		ArrayList<String> list = new ArrayList<>();
		for(int j = 0; j < wall; j++) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 5; i++) {
				sb.append(word[i][j]);
			}
			list.add(sb.toString());
		}
		int size = list.size();
		int[] target = new int[size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < 8; j++) {
				if(list.get(i).equals(str[j])) {
					target[i] = j + 1;
					break;
				}
			}
		}
		System.out.println(str[0]);
		System.out.println(list.get(0).equals(str[0]));
	}
}
