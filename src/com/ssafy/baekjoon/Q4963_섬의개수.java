package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4963_섬의개수 {
	static int[][] map, dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			map = new int[h][w];
			boolean[][] check = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!check[i][j] && map[i][j] == 1) {
						bfs(i, j, h, w, check);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
	public static void bfs(int i, int j, int h, int w, boolean[][] check) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		check[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d = 0; d < 8; d++) {
				int dy = cur[0] + dir[d][0];
				int dx = cur[1] + dir[d][1];
				
				if(isEnable(dy, dx, h, w) && !check[dy][dx] && map[dy][dx] == 1) {
					q.add(new int[] {dy, dx});
					check[dy][dx] = true;
				}
			}
		}
		
	}
	public static boolean isEnable(int i, int j, int N, int M) {
		return (i < N && i >= 0 && j < M && j >= 0);
	}
}
