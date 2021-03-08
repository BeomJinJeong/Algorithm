package com.ssafy.code.problem.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05_미로2 {
	static boolean[][] map;
	static int r, c, toR, toC;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			br.readLine();
			map = new boolean[100][100];
			for(int i = 0; i < 100; i++) {
				String str = br.readLine();
				for(int j = 0; j < 100; j++) {
					if(str.charAt(j) == '0') {
						map[i][j] = true;
					}
					if(str.charAt(j) == '2') {
						map[i][j] = true;
						r = i;
						c = j;
					} else if(str.charAt(j) == '3') {
						map[i][j] = true;
						toR = i; 
						toC = j;
					}
				}
			}
			if(dfs(r, c)) System.out.println("#" + t + " " + 1);
			else System.out.println("#" + t + " " + 0);
		}
	}
	private static boolean dfs(int r, int c) {
		if(!map[r][c]) return false;
		if(r == toR && c == toC) return true;
		map[r][c] = false;
		
		for(int i = 0; i < 4; i++) {
			int ny = r + dir[i][0];
			int nx = c + dir[i][1];
			if(ny < 0 | ny >= 100 | nx < 0 | nx >= 100) continue;
			
			if(map[ny][nx]) {
				if(dfs(ny, nx)) return true;
			}
		}
		return false;
	}
}
