package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1613_역사 {
	static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][N + 1];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			arr[front][back] = 1;
		}
		
		for(int k = 1; k <=N ; k ++) {
            for(int i = 1; i <= N ; i ++) {
                if(arr[i][k] == 1) {
                    for(int j = 1; j <= N ;j ++) {
                        if(arr[k][j] == 1 &&arr[i][j] == 0) {
                            arr[i][j] = 1;
                        }
                    }
                }
            }
        }
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			if(arr[first][second] == 1) System.out.println(-1);
			else if(arr[second][first] == 1) System.out.println(1);
			else System.out.println(0);
		}
	}
}
