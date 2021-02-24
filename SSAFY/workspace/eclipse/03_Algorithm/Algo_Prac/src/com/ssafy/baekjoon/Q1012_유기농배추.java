package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012_유기농배추 {
	static boolean[][] map;
	static int M, N, K;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int cnt = 0;
			map = new boolean[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = true;
			}
			outer : for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(solve(i, j)) cnt++;
					if(K == 0) break outer;
				}
			}
			System.out.println(cnt);
		}
	}
	private static boolean solve(int r, int c) {
		if(map[r][c]) {
			map[r][c] = false;
			K--;
			for(int i = 0; i < 4; i++) {
				int ny = r + dir[i][0];
				int nx = c + dir[i][1];
				
				if( ny < 0 | ny >= N | nx < 0 | nx >= M ) continue;
				if(map[ny][nx]) {
					if(!solve(ny, nx)) return false;
				}
			}
		} else return false;
		return true;
	}
}
