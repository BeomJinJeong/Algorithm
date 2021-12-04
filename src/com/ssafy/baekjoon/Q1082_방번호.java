package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1082_방번호 {
	static int[]input;
	static int N, K, min = Integer.MAX_VALUE, idx;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if(min >= input[i]) {
				min = input[i];
				idx = i;
			}
		}
		K = Integer.parseInt(br.readLine());
		solve();
	}
	private static void solve() {
		int size = K / min;
		int[] temp = new int[size];
		Arrays.fill(temp, idx);
		K -= min * size;
		int start = 0;
		for(int i = 0; i < size; i++) {
			for(int j = N - 1; j >= 0; j--) {
				if(input[j] <= (K + min)) {
					temp[i] = j;
					K += min - input[j];
					break;
				}
			}
			if(temp[start] == 0) {
				start++;
				K += min;
			}
		}
		if(start == size) {
			System.out.println(0);
			return;
		}
		for(int i = start; i < size; i++) {
			System.out.print(temp[i]);
		}
	}
}
