package com.ssafy.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q3985_롤케이크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		int[] bread = new int[T + 1];
		int[] arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			arr[i] = q - p + 1;
			for(int j = p; j <= q; j++) {
				if(bread[j] == 0) {
					bread[j] = i;
				}
			}
		}
		int lMax = arr[1];
		int max = 1;
		for(int i = 2; i <= N; i++) {
			if(lMax < arr[i]) {
				lMax = arr[i];
				max = i;
			}
		}
		System.out.println(max);
		Arrays.fill(arr, 0);
		for(int i = 0; i <= T; i++) {
			arr[bread[i]]++;
		}
		lMax = arr[1];
		max = 1;
		for(int i = 1; i <= N; i++) {
			if(lMax < arr[i]) {
				lMax = arr[i];
				max = i;
			}
		}
		System.out.println(max);
	}
}
