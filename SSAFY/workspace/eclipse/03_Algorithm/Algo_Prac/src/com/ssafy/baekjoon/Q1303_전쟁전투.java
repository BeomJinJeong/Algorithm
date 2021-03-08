package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1303_전쟁전투 {
	static char[][] map;
	static boolean[][] check;
	static int N, M, bCnt, wCnt;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		check = new boolean[M][N];
		for(int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int bSum = 0, wSum = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(dfs(i, j, map[i][j])) {
					if(map[i][j] == 'W') wSum += wCnt*wCnt;
					else if(map[i][j] == 'B') bSum += bCnt*bCnt;
				}
				wCnt = 0; bCnt = 0;
			}
		}
		System.out.println(wSum + " " + bSum);
	}
	private static boolean dfs(int r, int c, int val) {
		if(check[r][c]) return false;
		check[r][c] = true;
		if(map[r][c] == 'W') wCnt++;
		else if(map[r][c] == 'B') bCnt++;
		
		for(int i = 0; i < 4; i++) {
			int ny = r + dir[i][0];
			int nx = c + dir[i][1];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M && !check[ny][nx] && map[r][c] == map[ny][nx]) {
				if(!dfs(ny, nx, map[r][c])) return false;
			}
		}
		return true;
	}
}
