package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17144_미세먼지안녕 {
	static int[][] map, cleaner, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int R, C, T;
	static Queue<int[]> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		cleaner = new int[2][3];
		q = new LinkedList<>();
		int tmpIdx = 0;
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					cleaner[tmpIdx] = new int[] {i, j};
					tmpIdx++;
				}
			}
		}
		for(int i = 0; i < T; i++) {			
			spread();
			play();
			q.clear();
		}
		int sum = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum + 2);
	}
	private static void spread() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] != 0 && map[i][j] != -1) {
					q.offer(new int[] {i, j, map[i][j]});
				}
			}
		}
		while(!q.isEmpty()) {
			int cnt = 0;
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = cur[0] + dir[i][0];
				int nx = cur[1] + dir[i][1];
				
				if( ny >= 0 && ny < R && nx >= 0 && nx < C && map[ny][nx] != -1) {
					map[ny][nx] += cur[2] / 5;
					cnt++;
				}
			}
			map[cur[0]][cur[1]] -= (cur[2] / 5) * cnt;
		}
	}
	private static void play() {
		int y = cleaner[0][0] - 1;
		int x = cleaner[0][1];
		int idx = 0;
		while(true) {
			int ny = y + dir[idx][0];
			int nx = x + dir[idx][1];
			
			if(ny == cleaner[0][0] && nx == cleaner[0][1]) {
				map[y][x] = 0;
				break;
			}
			
			if( ny <= cleaner[0][0] && ny >= 0 && nx < C && nx >= 0 ) {
				map[y][x] = map[ny][nx];
				y = ny; x = nx;
			} else {
				idx = (idx + 1) % 4;
			}
			
		}
		y = cleaner[1][0] + 1;
		x = cleaner[1][1];
		idx = 2;
		while(true) {
			int ny = y + dir[idx][0];
			int nx = x + dir[idx][1];
			
			if(ny == cleaner[1][0] && nx == cleaner[1][1]) {
				map[y][x] = 0;
				break;
			}
			
			if( ny >= cleaner[1][0] && ny < R && nx < C && nx >= 0 ) {
				map[y][x] = map[ny][nx];
				y = ny; x = nx;
			} else {
				idx = (idx + 3) % 4;
			}
			
		}
	}
}
