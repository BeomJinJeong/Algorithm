package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5427_불 { // 다시 - 상근이 큐, 불 큐 따로 ㄱㄱ
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}, num, check;
	static char[][] building;
	static int fromX, fromY;
	static int W, H;
	static Queue<int[]> fire;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			building = new char[H][W];
			num = new int[H][W];
			check = new int[H][W];
			fire = new LinkedList<>();
			for(int i = 0; i < H; i++) {
				String str = br.readLine();
				for(int j = 0; j < W; j++) {
					building[i][j] = str.charAt(j);
					if(building[i][j] == '@') {
						fromY = i; fromX = j;
					} else if(building[i][j] == '*') {
						fire.offer(new int[] {i, j});
						check[i][j] = -1;
					} else if(building[i][j] == '#') {
						check[i][j] = -1;
					}
				}
			}
			bfs();
			fire.clear();
		}
	}
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {fromY, fromX});
		check[fromY][fromX] = 1;
		
		while(!q.isEmpty()) {
			int fireSize = fire.size();
			for(int i = 0; i < fireSize; i++) {
				int[] current = fire.poll();
				
				for(int j = 0; j < 4; j++) {
					int ny = current[0] + dir[j][0];
					int nx = current[1] + dir[j][1];
					
					if( nx < 0 | nx >= W | ny < 0 | ny >= H ) continue;
					
					if(check[ny][nx] != -1 ) {
						check[ny][nx] = -1;
						fire.offer(new int[] {ny, nx});
					}
				}
			}
			int qSize = q.size();
			for(int i = 0; i < qSize; i++) {
				int[] current1 = q.poll();
				
				for(int j = 0; j < 4; j++) {
					int ny = current1[0] + dir[j][0];
					int nx = current1[1] + dir[j][1];
					
					if( nx < 0 | nx >= W | ny < 0 | ny >= H ) continue;
					
					if(check[ny][nx] != -1 ) {
						q.offer(new int[] {ny, nx});
						num[ny][nx] = num[current1[0]][current1[1]] + 1;
						if( ny == 0 | ny == H-1 | nx == 0 | nx == W-1 ) {
							System.out.println(num[ny][nx] + 1);
							return;
						}
					}
					
				}				
			}
		}
		System.out.println("IMPOSSIBLE");
	}
}
