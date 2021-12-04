package com.ssafy.baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1192_부분수열의합_02 {
	static int N, count, S;
	static int[] numbers;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		check = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		subSetSum(0);
		System.out.println(count);
		count = 0;
		
	}
	public static void subSetSum(int cnt) {
		if(cnt == N) {
			int sum = 0, zero = 0;
			for(int i = 0; i < N; i++) {
				if(check[i]) {
					sum += numbers[i];
					zero++;
				}
			}
			if(zero > 0 && sum == S) {
				count++;
			}
			return;
		}
		check[cnt] = true;
		subSetSum(cnt + 1);
		check[cnt] = false;
		subSetSum(cnt + 1);
	}
}
