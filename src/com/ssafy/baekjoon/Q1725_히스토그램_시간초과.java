package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1725_히스토그램_시간초과 {	// 시간초과
	static long[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new long[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		long max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			long sum = solve(arr[i], i);
			if(max < sum) {
				max = sum;
			};
		}
		System.out.println(max);
	}
	private static long solve(long sum, int target) {
		for(int i = target + 1; i < arr.length; i++) {
			if(i != arr.length - 1) {
				if(arr[i] >= arr[target]) {
					sum += arr[target];
				}
				else break;				
			} else {
				if(arr[i] >= arr[target]) {
					sum += arr[target];
				}
			}
		}
		for(int i = target - 1; i > 0; i--) {
			if(i != 0) {
				if(arr[i] >= arr[target]) {
					sum += arr[target];
				}
				else break;				
			} else {
				if(arr[i] >= arr[target]) {
					sum += arr[target];
				}
			}
		}
		return sum;
	}
}
