package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9328_열쇠 {
	static int [][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static char[][] map;
	static int H, W, ans;
	static HashSet<Character> key;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new char[H][W];
			for(int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			key = new HashSet<>();
			char[] keys = br.readLine().toCharArray();
			for(int i = 0; i < keys.length; i++) {
				key.add(keys[i]);
			}
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(i == 0 || i == H - 1 || j == 0 || j == W - 1) {
						if(map[i][j] == '.') {
							ans += bfs(i, j);
						} else if(map[i][j] != '*' && Character.isLowerCase(map[i][j])) {
							ans += bfs(i, j);
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
	private static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> door = new ArrayList<>();
		boolean[][] check = new boolean[H][W];
		int cnt = 0;
		
		q.add(new int[] {r, c});
		check[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(map[cur[0]][cur[1]] == '$') {
				map[cur[0]][cur[1]] = '.';
				cnt++;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dir[i][0];
				int nc = cur[1] + dir[i][1];
				
				if(inRange(nr, nc) && map[nr][nc] != '*' && !check[nr][nc]) {
					if(map[nr][nc] == '.') {
						q.add(new int[] {nr, nc});
						check[nr][nc] = true;
					} else if(Character.isLowerCase(map[nr][nc])) {
						key.add(map[nr][nc]);
						q.add(new int[] {nr, nc});
						check[nr][nc] = true;						
					} else if(Character.isUpperCase(map[nr][nc])) {
						if(key.contains(Character.toLowerCase(map[nr][nc]))) {
							q.add(new int[] {nr, nc});
							check[nr][nc] = true;
						} else {
							door.add(new int[] {nr, nc});
							check[nr][nc] = true;
						}
					}
				}
			}
		}
		check = new boolean[H][W];
		for(int i = 0; i < door.size(); i++) {
			if(key.contains(Character.toLowerCase(map[door.get(i)[0]][door.get(i)[1]]))) {
				q.add(new int[] {door.get(i)[0], door.get(i)[1]});
				check[door.get(i)[0]][door.get(i)[1]] = true;
			}
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(map[cur[0]][cur[1]] == '$') {
				map[cur[0]][cur[1]] = '.';
				cnt++;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dir[i][0];
				int nc = cur[1] + dir[i][1];
				
				if(inRange(nr, nc) && map[nr][nc] != '*' && !check[nr][nc]) {
					if(map[nr][nc] == '.') {
						q.add(new int[] {nr, nc});
						check[nr][nc] = true;
					} else if(Character.isLowerCase(map[nr][nc])) {
						key.add(map[nr][nc]);
						q.add(new int[] {nr, nc});
						check[nr][nc] = true;						
					} else if(Character.isUpperCase(map[nr][nc])) {
						if(key.contains(Character.toLowerCase(map[nr][nc]))) {
							q.add(new int[] {nr, nc});
							check[nr][nc] = true;
						} else {
							door.add(new int[] {nr, nc});
							check[nr][nc] = true;
						}
					}
				}
			}
		}
		
		
		return cnt;
	}
	private static boolean inRange(int r, int c) {
		return (r < H && r >= 0 && c < W && c >= 0);
	}
}
