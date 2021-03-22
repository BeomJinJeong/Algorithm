package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17086_아기상어2 {
	static int[][] map, dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static boolean[][] check;
	static int N, M;
	static Queue<int[]> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];
		q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 1) {
					q.offer(new int[] {i, j});
					check[i][j] = true;
				}
			}
		}
		bfs();
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(max < map[i][j]) max = map[i][j];
			}
		}
		System.out.println(max);
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int ny = cur[0] + dir[i][0];
				int nx = cur[1] + dir[i][1];
				if( nx < M && nx >= 0 && ny < N && ny >= 0 && !check[ny][nx] && map[ny][nx] == 0) {
					q.offer(new int[] {ny, nx});
					check[ny][nx] = true;
					map[ny][nx] = map[cur[0]][cur[1]] + 1;
				}
			}
		}
	}
}
