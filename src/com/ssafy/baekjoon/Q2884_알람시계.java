package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2884_알람시계 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int hour = Integer.parseInt(input[0]);
		int min = Integer.parseInt(input[1]);
		
		if(min - 45 < 0) {
			hour--;
			min = 60 + (min - 45);
		} else min -= 45;
		
		if(hour < 0) {
			hour = 24 + hour;
		}
		
		System.out.println(hour + " " + min);
	}
}
