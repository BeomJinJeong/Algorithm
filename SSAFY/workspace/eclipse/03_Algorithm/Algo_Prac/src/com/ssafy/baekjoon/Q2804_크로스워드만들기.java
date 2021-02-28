package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2804_크로스워드만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] w1 = st.nextToken().toCharArray();
		char[] w2 = st.nextToken().toCharArray();
		int wo1 = 0, wo2 = 0;
		outer : for(int i = 0; i < w1.length; i++) {
			for(int j = 0; j < w2.length; j++) {
				if(w1[i] == w2[j]) {
					wo1 = i;
					wo2 = j;
					break outer;
				}
			}
		}
		char[][] map = new char[w2.length][w1.length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = '.';
			}
		}
		for(int i = 0; i < w1.length; i++) {
			map[wo2][i] = w1[i];
		}
		for(int i = 0; i < w2.length; i++) {
			map[i][wo1] = w2[i];
		}
		for(int i = 0; i < map.length; i++) {
			for(char a : map[i]) {
				System.out.print(a);
			}
			System.out.println();
		}
	}
}
