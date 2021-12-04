package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q08_알파벳 {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 위, 오, 아, 왼
	static int R, C, cnt = 1, max = 0;
	static char[][] map;
	static HashSet<Character> check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new HashSet<>();
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				char target = str.charAt(j);
				map[i][j] = target;
			}
		}
		check.add(map[0][0]);
		dfs(0, 0);
		System.out.println(max);
	}
	private static void dfs(int r, int c) {
		
		int nr = 0, nc = 0;
		for(int i = 0; i < 4; i++) {
			nr = r + dir[i][0];
			nc = c + dir[i][1];
			if( nr < 0 || nr >= R || nc < 0 || nc >= C || check.contains(map[nr][nc])) continue;
			check.add(map[nr][nc]);
			cnt++;
			dfs(nr, nc);
			cnt--;
			check.remove(map[nr][nc]);
		}
		max = Math.max(cnt, max);
	}
}
