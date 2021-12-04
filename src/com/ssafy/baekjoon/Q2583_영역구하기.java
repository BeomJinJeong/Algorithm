package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q2583_영역구하기 {
	static boolean[][] map;
	static int N, M, K, totalCnt = 0, cnt;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for(int k = r; k < h; k++) {
				for(int j = c; j < w; j++) {
					map[k][j] = true;
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int j = 0; j < N; j++) {
			for(int k = 0; k < M; k++) {
				if(dfs(j, k)) {
					totalCnt++;
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		System.out.println(totalCnt);
		Collections.sort(list);
		for(int a : list) {
			System.out.print(a + " ");
		}
	}
	public static boolean dfs(int r, int c) {
		if(map[r][c]) return false;
		map[r][c] = true;
		for(int i = 0; i < 4; i++) {
			int ny = r + dir[i][0];
			int nx = c + dir[i][1];
			
			if(nx < 0 | nx >= M | ny < 0 | ny >= N) continue;
			if(!map[ny][nx]) {
				if(!dfs(ny, nx)) return false;
			}					
		}
		cnt++;
		return true;
	}
}
