package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Q1261_알고스팟 {
	static class Pos{
		int y;
		int x;
		int cnt;
		public Pos(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	static int N, M;
	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		bfs();
	}
	private static void bfs() {
		PriorityQueue<Pos> q = new PriorityQueue<>(new Comparator<Pos>() {
			@Override
			public int compare(Pos o1, Pos o2) {
				return o1.cnt - o2.cnt;
			}
		});
		q.add(new Pos(0, 0, 0));
		check = new boolean[N][M];
		check[0][0] = true;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.x == M - 1 && cur.y == N - 1) {
				System.out.println(cur.cnt);
				return;
			}
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dir[i][0];
				int nx = cur.x + dir[i][1];
				if(ny < N && ny >= 0 && nx < M && nx >= 0 && !check[ny][nx]) {
					if(map[ny][nx] == 0) {
						q.add(new Pos(ny, nx, cur.cnt));
						check[ny][nx] = true;
					} else if(map[ny][nx] == 1) {
						q.add(new Pos(ny, nx, cur.cnt + 1));
						check[ny][nx] = true;
					}
				}
			}
		}
	}
}
