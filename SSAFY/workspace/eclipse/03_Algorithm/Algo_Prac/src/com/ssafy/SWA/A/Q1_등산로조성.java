package com.ssafy.SWA.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1_등산로조성 {
	static int[][] map, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int N, K, cnt;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cnt = 0;
			int max_height = 0;
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(max_height < map[i][j]) max_height = map[i][j];
				}
			}
			
			list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == max_height) {
						list.add(new int[] {i, j});
					}
				}
			}
			for(int[] a : list) {
				boolean[][] check = new boolean[N][N];
				check[a[0]][a[1]] = true;
				dfs(a, 1, check, true);
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
	private static void dfs(int[] arr, int s, boolean[][] check, boolean flag) {
		cnt = Math.max(s, cnt);
		int h = map[arr[0]][arr[1]];
		
		for(int i = 0; i < 4; i++) {
			int ny = arr[0] + dir[i][0];
			int nx = arr[1] + dir[i][1];
			if( nx >= 0 && nx < N && ny >= 0 && ny < N && !check[ny][nx]) {
				if(h > map[ny][nx]) {
					check[ny][nx] = true;
					dfs(new int[] {ny, nx}, s + 1, check, flag);
					check[ny][nx] = false;
				} else {
					if(flag) {
						for(int j = 1; j <= K; j++) {
							if(h > map[ny][nx] - j) {
								check[ny][nx] = true;
								map[ny][nx] -= j;
								dfs(new int[] {ny, nx}, s + 1, check,  false);
								map[ny][nx] += j;
								check[ny][nx] = false;
								break;
							}
						}
					}
				}
			}
		}
	}
}
