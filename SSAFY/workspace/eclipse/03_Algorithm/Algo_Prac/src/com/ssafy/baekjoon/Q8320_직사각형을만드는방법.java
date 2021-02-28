package com.ssafy.baekjoon;

import java.util.Scanner;

public class Q8320_직사각형을만드는방법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 1;
		for(int i = 2; i <= N; i++) {
			cnt += getNum(i);
		}
		System.out.println(cnt);
		sc.close();
	}
	public static int getNum(int n) {
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				cnt ++;
				if(i * i == n) cnt++;
			}
		}
		return cnt / 2;
	}
}
