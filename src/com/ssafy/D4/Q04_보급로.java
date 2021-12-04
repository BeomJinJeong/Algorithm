package com.ssafy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q04_보급로 {
	static int N;
	static int[][] map, num, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			num = new int[N][N];
			for(int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split("");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			for(int i = 0; i < N; i++) {
				Arrays.fill(num[i], Integer.MAX_VALUE);
			}
			num[0][0] = 0;
			bfs();
			System.out.println("#" + t + " " + num[N-1][N-1]);
		}
	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] check = new boolean[N][N];
		q.add(new int[] {0, 0});
		check[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = cur[0] + dir[i][0];
				int nx = cur[1] + dir[i][1];
				
				if(inRange(ny, nx)) {
					if(num[cur[0]][cur[1]] + map[ny][nx] < num[ny][nx]) {
						q.add(new int[] {ny, nx});
						num[ny][nx] = num[cur[0]][cur[1]] + map[ny][nx];
					}
				}
			}
		}
	}
	private static boolean inRange(int r, int c) {
		return (r < N && r >= 0 && c < N && c >= 0);
	}
}
