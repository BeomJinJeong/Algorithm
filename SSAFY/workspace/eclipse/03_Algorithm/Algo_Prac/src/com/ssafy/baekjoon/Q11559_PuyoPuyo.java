package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q11559_PuyoPuyo {	
	static char[][] map = new char[12][6];
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] check;
	static ArrayList<int[]> list;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		list = new ArrayList<>();
		check = new boolean[12][6];
		
		while(true) {			
			for(int i = 0; i < 12; i++) {
				for(int j = 0; j < 6; j++) {
					if(map[i][j] != '.' && !check[i][j]) {
						bfs(i, j, map[i][j]);					
					}				
				}
			}
			if(list.size() > 0) {									
				for(int[] a : list) {
					map[a[0]][a[1]] = '.';
				}
				ans++;
				goDown();
				list.clear(); 
				check = new boolean[12][6];
			} else break;
		}
		System.out.println(ans);
		
	}
	private static void bfs(int r, int c, char target) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		check[r][c] = true;
		ArrayList<int[]> tmp = new ArrayList<>();
		tmp.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = cur[0] + dir[i][0];
				int nx = cur[1] + dir[i][1];
				
				if(inRange(ny, nx) && !check[ny][nx] && map[ny][nx] == target) {
					q.add(new int[] {ny, nx});
					check[ny][nx] = true;
					tmp.add(new int[] {ny, nx});
				}
			}
		}
		if(tmp.size() >= 4) {
			for(int[] a : tmp) list.add(a);
		}
	}
	private static void goDown() {
		for(int i = 11; i >= 0; i--) {
			for(int j = 5; j >= 0; j--) {
				if(map[i][j] == '.') {
					for(int k = i; k >= 0; k--) {
						if(map[k][j] != '.') {
							map[i][j] = map[k][j];
							map[k][j] = '.';
							break;
						}
					}
				}
			}
		}
	}
	private static boolean inRange(int r, int c) {
		return (r < 12 && r >= 0 && c < 6 && c >= 0);
	}
}
