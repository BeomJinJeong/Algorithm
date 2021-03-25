package com.ssafy.baekjoon;

import java.util.Scanner;

public class Q9625_BABBA {	// 실패
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[] arr = {1, 0};
		for(int i = 0; i < K; i++) {
			arr[1] += arr[0];
			arr[0] = arr[1] - arr[0];
		}
		System.out.println(arr[0] + " " + arr[1]);
		sc.close();
	}
}
