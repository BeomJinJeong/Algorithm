package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2206_벽부수고이동하기 {
	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int r, c;
	static boolean[][][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		check = new boolean[r][c][2];
		for(int i = 0; i < r; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		bfs();
	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 1, 0});
		check[0][0][1] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == r - 1 && cur[1] == c - 1) {
				System.out.println(cur[3] + 1);
				return;
			}
			for(int i = 0; i < 4; i++) {
				int ny = cur[0] + dir[i][0];
				int nx = cur[1] + dir[i][1];
				if(inRange(ny, nx) && !check[ny][nx][cur[2]]) {
					if(map[ny][nx] == 1 && cur[2] > 0) {
						q.add(new int[] {ny, nx, cur[2] - 1, cur[3] + 1});
						check[ny][nx][cur[2] - 1] = true;
					} else if(map[ny][nx] == 0) {
						q.add(new int[] {ny, nx, cur[2], cur[3] + 1});
						check[ny][nx][cur[2]] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
	private static boolean inRange(int y, int x) {
		return (y < r && y >= 0 && x < c && x >= 0);
	}
}
