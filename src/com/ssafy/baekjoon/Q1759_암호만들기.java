package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1759_암호만들기 {
	static String[] input, res;
	static String str = "aeiou";
	static String str2 = "bcdfghjklmnpqrstvwxyz";
	static int L, C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new String[C];
		res = new String[L];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			input[i] = st.nextToken();
		}
		Arrays.sort(input);
		comb(0, 0);
	}
	public static void comb(int cnt, int start) {
		if(cnt == L) {
			int count = 0;
			boolean mo = false;
			Arrays.sort(res);
			for(String a : res) {
				if(str.contains(a)) {
					mo = true;
					break;
				}
			}
			for(String a : res) {
				if(str2.contains(a)) count++;
			}
			if(mo && count >= 2) {
				for(String a : res) {
					System.out.print(a);
				}
				System.out.println();
			} else return;
			return;
		}
		for(int i = start; i < input.length; i++) {
			res[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
}
