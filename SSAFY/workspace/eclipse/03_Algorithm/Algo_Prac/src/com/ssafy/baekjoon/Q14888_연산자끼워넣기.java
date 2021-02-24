package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888_연산자끼워넣기 {
	static int[] number, oper;
	static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		oper = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(number[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int num, int cnt) {
		if(cnt == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(oper[i] > 0) {
				oper[i]--;
				switch(i) {
				case 0 : dfs(num + number[cnt], cnt + 1); break;
				case 1 : dfs(num - number[cnt], cnt + 1); break;
				case 2 : dfs(num * number[cnt], cnt + 1); break;
				case 3 : dfs(num / number[cnt], cnt + 1); break;
				}
				oper[i]++;
			}
		}
	}
}
