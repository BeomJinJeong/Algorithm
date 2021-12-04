package com.ssafy.code.problem.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02_나는개구리로소이다 {
	static int[] std;
	static boolean flag;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			cnt = 0;
			flag = true;
			std = new int[5];
			char[] str = br.readLine().toCharArray();
			outer : for(int i = 0; i < str.length; i++) {
				switch(str[i]) {
				case 'c':
					std[0]++;
					break;
				case 'r':
					std[1]++;
					if(!check(std)) break outer;
					break;
				case 'o':
					std[2]++;
					if(!check(std)) break outer;
					break;
				case 'a':
					std[3]++;
					if(!check(std)) break outer;
					break;
				case 'k':
					std[4]++;
					fin(std);
					if(!check(std)) break outer;
					break;
				}
			}
			for(int i = 0; i < 5; i++) {
				if(std[i] > 0) {
					flag = false;
					break;
				}
			}
			if(flag) System.out.println("#" + t + " " + cnt);
			else System.out.println("#" + t + " -1");
		}
	}
	private static boolean check(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[i - 1]) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	private static void fin(int[] arr) {
		cnt = Math.max(cnt, arr[0]);
		for(int i = 0; i < arr.length; i++) {
			arr[i]--;
		}
	}
}
