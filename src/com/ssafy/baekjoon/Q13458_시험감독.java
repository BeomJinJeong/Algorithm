package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13458_시험감독 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] classroom = new int[N];
		long cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			classroom[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			classroom[i] -= B;
			cnt++;
			if(classroom[i] <= 0) continue;
			if(classroom[i] % C == 0) cnt += classroom[i]/C;
			else {
				cnt += classroom[i]/C;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
