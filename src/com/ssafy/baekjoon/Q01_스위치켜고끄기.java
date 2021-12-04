package com.ssafy.baekjoon;

import java.util.Scanner;

public class Q01_스위치켜고끄기 {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int[] arr = new int[N];
	public static void main(String[] args) {
		Q01_스위치켜고끄기 q = new Q01_스위치켜고끄기();
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int stds = sc.nextInt();
		
		for(int j = 0; j < stds; j++) {
			int gender = sc.nextInt();
			int pos = sc.nextInt();
			
			if(gender == 1) q.boy(pos);
			else q.girl(pos-1, 1);
		}
		System.out.print(arr[0]);
		for(int i = 1; i < arr.length; i++){
			if(i%20 == 0) {
				System.out.println();
				System.out.print(arr[i]);
				continue;
			}
			System.out.print(" " + arr[i]);
		}
		sc.close();
	}
	public void boy(int i) {
		for(int j = 0; j < N; j++) {
			if((j+1)%i == 0) {
				if(arr[j] == 0) arr[j] = 1;
				else arr[j] = 0;
			}
		}
	}
	public void girl(int i, int j) {
		if(i + j >= N | i - j < 0 ) {
			if( arr[i]==0 ) arr[i]=1;
			else arr[i] = 0;
			return;
		}
		if(arr[i - j] != arr[i + j]) {
			if( arr[i]==0 ) arr[i]=1;
			else arr[i] = 0;
			return;
		}
		if(arr[i - j]==1) { arr[i - j] = 0; }
		else arr[i-j] = 1;
		if(arr[i + j]==1) { arr[i + j] = 0; }
		else arr[i + j] = 1;
		girl(i, j+1);
	}
	
}