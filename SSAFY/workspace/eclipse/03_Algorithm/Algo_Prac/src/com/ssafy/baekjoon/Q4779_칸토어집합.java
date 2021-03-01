package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q4779_칸토어집합 {
	static char[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		
		while(true) {
			int N = Integer.parseInt(input);
			if(N == 0) {
				System.out.println('-');
				input = br.readLine();
				continue;
			}
			double T = Math.pow(3, N);
			arr = new char[(int)T];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = '-';
			}
			div(0, arr.length);
			for(char a : arr) {
				bw.write(a);
			}
			bw.newLine();
			bw.flush();
			input = br.readLine();
			if(input == null) {
				break;
			}
		}
		bw.close();
	}
	private static void div(int c, int n) {
		if(n == 3) {
			arr[c + 1] = ' ';
			return;
		} else {
			int size = n / 3;
			for(int i = 0; i < 3; i++) {
				if(i == 1) {
					blank(c + size, size);
					continue;
				}
				div(c + size * i, size);
			}
		}
	}
	private static void blank(int c, int n) {
		for(int i = c; i < c + n; i++) {
			arr[i] = ' ';
		}
	}
}
