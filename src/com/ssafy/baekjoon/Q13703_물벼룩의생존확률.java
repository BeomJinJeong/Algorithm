package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q13703_물벼룩의생존확률 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		long K = Long.parseLong(st.nextToken());
		long N = Long.parseLong(st.nextToken());
		
		long[][] arr = new long[(int) (N + 1)][(int) (K + N + 1)];
		arr[0][(int) K] = 1;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K + N; j++) {
				if(arr[i - 1][j] > 0) {
					arr[i][j - 1] += arr[i - 1][j];
					arr[i][j + 1] += arr[i - 1][j];
				}
			}
		}
		long ans = 0;
		for(int i = 1; i < arr[(int) N].length; i++) {
			ans += arr[(int) N][i];
		}
		System.out.println(ans);
    }
}
