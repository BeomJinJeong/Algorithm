package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13300_방배정 {
	static int[] boy, girl;
	static int N, K, cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		boy = new int[6];
		girl = new int[6];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			if(gender == 0) girl[year - 1]++;
			else boy[year - 1]++;
		}
		
		for(int i = 0; i < 6; i++) {
			if(boy[i] > 0) {
				boy[i] -= K;
				cnt++;
				if(boy[i] > 0) {
					i--;
					continue;
				}
			}
		}
		for(int i = 0; i < 6; i++) {
			if(girl[i] > 0) {
				girl[i] -= K;
				cnt++;
				if(girl[i] > 0) {
					i--;
					continue;
				}
			}
		}
		System.out.println(cnt);
	}
}
