package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10026_적록색약 {
	static char[][] map;
	static boolean[][] check;
	static int cnt, Gcnt, N;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		check = new boolean[N][N];
		for(int i = 0; i < N; i++){
			map[i] = br.readLine().toCharArray();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(dfs(i, j)) cnt++;
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'R') map[i][j] = 'G';
			}
		}
		for(int i = 0; i < N; i++) {
			Arrays.fill(check[i], false);
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(dfs(i, j)) Gcnt++;
			}
		}
		System.out.println(cnt + " " + Gcnt);
		
	}
	private static boolean dfs(int i, int j) {
		if(check[i][j]) return false;
		char a = map[i][j];
		check[i][j] = true;
		
		for(int k = 0; k < 4; k++) {
			int ny = i + dir[k][0];
			int nx = j + dir[k][1];
			
			if(nx < 0 | nx >= N | ny < 0 | ny >= N ) continue;
			if(!check[ny][nx] && map[ny][nx] == a) {
				if(!dfs(ny, nx)) return false;
			}
		}
		return true;
	}
}
