 package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1743_음식물피하기 {
	static boolean[][] map, check;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int N, M, K, max, sum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		check = new boolean[N][M];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(dfs(i, j)) {
					max = Math.max(sum, max);
					sum = 0;
				}
			}
		}
		System.out.println(max);
	}
	private static boolean dfs(int r, int c) {
		if(check[r][c]) return false;
		if(!map[r][c]) return false;;
		sum++;
		check[r][c] = true;
		for(int i = 0; i < 4; i++) {
			int ny = r + dir[i][0];
			int nx = c + dir[i][1];
			if(nx < 0 | nx >= M | ny < 0 | ny >= N) continue;
			if(map[ny][nx] && !check[ny][nx]) {
				dfs(ny, nx);
				check[ny][nx] = true;
			}
		}
		return true;
	}
}
