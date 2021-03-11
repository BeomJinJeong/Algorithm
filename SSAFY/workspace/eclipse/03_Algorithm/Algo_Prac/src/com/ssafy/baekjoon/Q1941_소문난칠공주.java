package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Position {
	int x;
	int y;
	char val;
	public Position(int x, int y, char val) {
		super();
		this.x = x;
		this.y = y;
		this.val = val;
	}
}
public class Q1941_소문난칠공주 {
	static char[][] map = new char[5][5];
	static Position[] res = new Position[7];
	static boolean[][] check = new boolean[5][5];
	static int cnt; 
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		comb(0, 0);
		System.out.println(cnt);
	}
	private static void comb(int cnt, int start) {
		if(cnt == 7) {
			int sCnt = 0;
			for(Position a : res) {
				if(a.val == 'S') sCnt++;
			}
			if(sCnt >= 4) {
				bfs();
			}
			return;
		}
		for(int i = start; i < 25; i++) {
			int y = i / 5;
			int x = i % 5;
			res[cnt] = new Position(x, y, map[y][x]);
			check[y][x] = true;
			comb(cnt + 1, i + 1);
			check[y][x] = false;			
		}
	}
	private static void bfs() {
		Queue<Position> q = new LinkedList<>();
		boolean[][] visited = new boolean[5][5];
		int num = 1;
		q.add(res[0]);
		visited[res[0].y][res[0].x] = true;
		
		while(!q.isEmpty()) {
			Position p = q.poll();
			int x = p.x;
			int y = p.y;
			for(int i = 0; i < 4; i++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				if( nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && check[ny][nx] && !visited[ny][nx]) {
					q.offer(new Position(nx, ny, map[nx][ny]));
					visited[ny][nx] = true;
					num++;
				}
			}
			
		}
		if(num == 7) cnt++;
	}
}
