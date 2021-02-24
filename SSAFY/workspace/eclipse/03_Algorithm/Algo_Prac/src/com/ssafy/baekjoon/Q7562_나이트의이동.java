package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class night {
	int y;
	int x;
	public night(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}
public class Q7562_나이트의이동 {
	static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}}, map;
	static int I, count = 0;
	static Queue<night> queue;
	static int posX, posY, toX, toY;
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			I = Integer.parseInt(st.nextToken());
			map = new int[I][I];
			st = new StringTokenizer(br.readLine());
			posY = Integer.parseInt(st.nextToken());
			posX = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			toY = Integer.parseInt(st.nextToken());
			toX = Integer.parseInt(st.nextToken());
			queue = new LinkedList<>();
			check = new boolean[I][I];

			bfs(new night(posY, posX));
			System.out.println(map[toY][toX]);
		}
	}
	public static void bfs(night n) {
		if(n.y == toY && n.x == toX) return;
		check[n.y][n.x] = true;
		queue.offer(n);
		
		while(!queue.isEmpty()) {
			night current = queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int ny = current.y + dir[i][0];
				int nx = current.x + dir[i][1];
				
				if( ny < 0 | ny >= I | nx < 0 | nx >= I ) continue;
				if(!check[ny][nx]) {
					check[ny][nx] = true;
					map[ny][nx] = map[current.y][current.x] + 1;
					queue.offer(new night(ny, nx));
				}
			}
		}
	}
}
