package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q13460_구슬탈출2 {	// 실패. 뭔가 blue, red 변수와 언제 성공판단 해야할지 가려야할듯. 현재까지 웬만한 반레 다 맞음. 8%에서 틀림.
	static class Pos {
		int redX;
		int redY;
		int blueX;
		int blueY;
		int cnt;
		public Pos(int redX, int redY, int blueX, int blueY, int cnt) {
			super();
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.cnt = cnt;
		}	
	}
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int N, M, toY, toX;
	static char[][] map;
	static boolean[][][][] check;
	static Queue<Pos> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		check = new boolean[N][M][N][M];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int rx = 0, ry = 0, bx = 0, by = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'R') {
					ry = i; rx = j;
				}
				if(map[i][j] == 'B') {
					by = i; bx = j;
				}
				if(map[i][j] == 'O') {
					toY = i; toX = j;
				}
			}
		}
		bfs(new Pos(rx, ry, bx, by, 0));
	}
	private static void bfs(Pos pos) {
		q = new LinkedList<>();
		q.add(pos);
		check[pos.redY][pos.redX][pos.blueY][pos.blueX] = true;
		boolean red = false, blue = false, bluePassed = false;;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.cnt >= 10) continue;
			if(map[cur.redY][cur.redX] == 'O' && red && !blue) {
				System.out.println(cur.cnt);
				return;
			}
			for(int i = 0; i < 4; i++) {
				int ry = cur.redY;
				int rx = cur.redX;
				int by = cur.blueY;
				int bx = cur.blueX;
				
				while(true) {
					ry += dir[i][0];
					rx += dir[i][1];
					
					if(ry == toY && rx == toX) {
						red = true;
						break;
					}
					if(ry == by && rx == bx) {
						bluePassed = true;
					}
					
					if(map[ry][rx] == '#') {
						ry -= dir[i][0];
						rx -= dir[i][1]; 
						break;
					}
				}
				if(bluePassed) {
					ry -= dir[i][0];
					rx -= dir[i][1]; 
				}
				
				
				while(true) {
					by += dir[i][0];
					bx += dir[i][1];
					
					if(by == toY && bx == toX) {
						blue = true;
						break;
					}
					
					if(map[by][bx] == '#' || (!bluePassed && (rx == bx && ry == by))) {
						by -= dir[i][0];
						bx -= dir[i][1];
						break;
					}
				}				
				if(blue) {
					blue = false;
					continue;
				}
				if(!check[ry][rx][by][bx]) {
					q.add(new Pos(rx, ry, bx, by, cur.cnt + 1));
					check[ry][rx][by][bx] = true;
				}
				bluePassed = false;
			}
		}
		System.out.println(-1);
	}	
}
