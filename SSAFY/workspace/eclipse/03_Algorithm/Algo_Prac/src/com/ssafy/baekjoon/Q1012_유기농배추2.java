package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012_유기농배추2 {
	static int[][] map;
	static int M, N, K;
	static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int cnt = 0;
			map = new int[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			outer : for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] != 0) {
						dfs(i, j);
						cnt++;
					}
					if(K == 0) break outer;
				}
			}
			System.out.println(cnt);
		}
	}
	 public static void dfs(int X, int Y) {
		 
	        for (int i = 0; i < 4; i++) {
	            int nextX = X + dx[i];
	            int nextY = Y + dy[i];
	 
	            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
	                continue;
	            }
	            if (map[nextX][nextY] == 0) {
	                continue;
	            }
	            map[nextX][nextY] = 0;
	            K--;
	            dfs(nextX, nextY);
	        }
	    }
}
