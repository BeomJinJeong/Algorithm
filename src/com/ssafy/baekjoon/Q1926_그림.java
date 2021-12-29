package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1926_그림 {
	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int N, M, ans;
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		map = new int[N][M];
		check = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!check[i][j] && map[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		if(cnt == 0) System.out.println(0);
		else System.out.println(ans);
	}
	
	static public void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i, j});
		check[i][j] = true;
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			cnt++;
			for(int d = 0; d < 4; d++) {
				int dy = cur[0] + dir[d][0];
				int dx = cur[1] + dir[d][1];
				
				if(isEnable(dy, dx) && !check[dy][dx] && map[dy][dx] == 1) {
					q.add(new int[] {dy, dx});
					check[dy][dx] = true;
				}
			}
		}
		ans = Math.max(ans, cnt);
	}
	
	static boolean isEnable(int a, int b) {
		return (a < N && a >= 0 && b < M && b >= 0);
	}
}
