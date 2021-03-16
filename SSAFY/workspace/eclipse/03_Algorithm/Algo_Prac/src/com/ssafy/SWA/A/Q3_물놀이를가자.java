package com.ssafy.SWA.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	char val;
	public Pos(int y, int x, char val) {
		super();
		this.y = y;
		this.x = x;
		this.val = val;
	}
}
public class Q3_물놀이를가자 {
	static Pos[][] map;
	static int[][] arr, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};;
	static int N, M;
	static Queue<Pos> q;
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new Pos[N][M];
			check = new boolean[N][M];
			arr = new int[N][M];
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < M; j++) {
					map[i][j] = new Pos(i, j, str.charAt(j));
				}
			}
			q = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j].val == 'W') {
						q.offer(map[i][j]);
						check[i][j] = true;
					}
				}
			}
			bfs();
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j].val == 'L') {
						sum += arr[i][j];
					}
				}
			}
			System.out.println("#" + t + " " + sum);
		}
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			int y = cur.y;
			int x = cur.x;
			for(int i = 0; i < 4; i++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				if(nx >= 0 && nx < M && ny >= 0 && ny < N && !check[ny][nx]) {
					arr[ny][nx] = arr[y][x] + 1;
					check[ny][nx] = true;
					q.offer(map[ny][nx]);
				}
			}
		}
	}
}