package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3055_탈출 {
	static int R, C;
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}, num;
	static char[][] map;
	static boolean result = false;
	static boolean[][] check;
	static Queue<int[]> queue;
	static int fromX, fromY, fireX, fireY, toX, toY;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		num = new int[R][C];
		check = new boolean[R][C];
		queue = new LinkedList<>();
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					fromY = i; fromX = j;
				} else if(map[i][j] == '*') {
					queue.offer(new int[] {i, j});
					check[i][j] = true;
				} else if(map[i][j] == 'D') {
					toY = i; toX = j;
				}
			}
		}
		bfs();
	}
	static void bfs() {
		queue.offer(new int[] {fromY, fromX});
		check[fromY][fromX] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for(int i = 0; i < 4; i++) {
				int ny = current[0] + dir[i][0];
				int nx = current[1] + dir[i][1];
				
				if(ny < 0 | ny >= R | nx < 0 | nx >= C ) continue;
				
				if(map[current[0]][current[1]] == 'S') {
					if(map[ny][nx] == '.') {
						if(!check[ny][nx]) {
							check[ny][nx] = true;
							queue.offer(new int[] {ny, nx});
							map[ny][nx] = 'S';
							num[ny][nx] = num[current[0]][current[1]] + 1;
						}
					} else if(map[ny][nx] == 'D') {
						if(!check[ny][nx]) {
							check[ny][nx] = true;
							num[ny][nx] = num[current[0]][current[1]] + 1;
							result = true;
							break;
						}
					}
				} else {
					if(map[ny][nx] == '.') {
						if(!check[ny][nx]) {
							check[ny][nx] = true;
							queue.offer(new int[] {ny, nx});
						}
					}
				}
				
			}
		}
		if(result) System.out.println(num[toY][toX]);
		else System.out.println("KAKTUS");
	}
}
