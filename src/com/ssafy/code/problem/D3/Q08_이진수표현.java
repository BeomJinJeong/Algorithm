package com.ssafy.code.problem.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q08_이진수표현 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			StringBuilder str = new StringBuilder();
			if(str.length() < 30) {
				for(int i = 30; i > Integer.toBinaryString(M).length(); i--) {
					str.append("0");
				}
			}
			str.append(Integer.toBinaryString(M));
			int a = str.length() - N; boolean check = true;
			for(int i = a; i < str.length(); i++) {
				if(str.substring(i, i+1).equals("0")) {
					System.out.println("#" + t + " OFF");
					check = false;
					break;
				}
			}
			if(check) System.out.println("#" + t + " ON");
		}
	}
}
