package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Robot {
	int y;
	int x;
	int dir;
	int cnt;
	public Robot(int y, int x, int dir, int cnt) {
		super();
		this.y = y;
		this.x = x;
		this.dir = dir;
		this.cnt = cnt;
	}
}
public class Q1726_로봇 {
	
	static int[][] map, dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동서남북
	static int N, M, fromY, fromX, fromDir, toY, toX, toDir, ans = Integer.MAX_VALUE;
	static boolean[][][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		check = new boolean[M][N][4];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		fromY = Integer.parseInt(st.nextToken()) - 1;
		fromX = Integer.parseInt(st.nextToken()) - 1;
		fromDir = Integer.parseInt(st.nextToken()) - 1; 
		
		st = new StringTokenizer(br.readLine());
		toY = Integer.parseInt(st.nextToken()) - 1;
		toX = Integer.parseInt(st.nextToken()) - 1;
		toDir = Integer.parseInt(st.nextToken()) - 1;
		
		bfs();
		System.out.println(ans);
	}
	private static void bfs() {
		Queue<Robot> q = new LinkedList<>();
		q.add(new Robot(fromY, fromX, fromDir, 0));
		check[fromY][fromX][fromDir] = true;
		
		while(!q.isEmpty()) {
			Robot cur = q.poll();
			if(cur.dir == toDir && cur.x == toX && cur.y == toY) {
				ans = Math.min(cur.cnt, ans);
				continue;
			}
			for(int i = 1; i < 4; i++) {
				int ny = cur.y + (dir[cur.dir][0] * i);
				int nx = cur.x + (dir[cur.dir][1] * i);
				
				if( !inRange(nx, ny)) break;
				if(map[ny][nx] == 1) break;
				if(check[ny][nx][cur.dir]) continue;
				else {
					q.add(new Robot(ny, nx, cur.dir, cur.cnt + 1));
					if(nx == toX && ny == toY && cur.dir == toDir) {
					} else {						
						check[ny][nx][cur.dir] = true;
					}					
				}
			}
			int left = 0;
			int right = 0;
			// 0123 동서남북
			switch(cur.dir) {
			case 0: left = 3; right = 2; break;
			case 1: left = 2; right = 3; break;
			case 2: left = 0; right = 1; break;
			case 3: left = 1; right = 0; break;
			}
			if(!check[cur.y][cur.x][left]) {
				q.add(new Robot(cur.y, cur.x, left, cur.cnt + 1));
				if(cur.y == toY && cur.x == toX && left == toDir) {
					
				} else {					
					check[cur.y][cur.x][left] = true;
				}
			}
			if(!check[cur.y][cur.x][right]) {
				q.add(new Robot(cur.y, cur.x, right, cur.cnt + 1));
				if(cur.y == toY && cur.x == toX && right == toDir) {
					
				} else {					
					check[cur.y][cur.x][right] = true;
				}
			}
		}
	}
	private static boolean inRange(int x, int y) {
		if( x < N && x >= 0 && y < M && y >= 0 ) return true;
		else return false;
	}
}
