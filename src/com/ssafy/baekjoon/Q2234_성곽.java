package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2234_성곽 {
	static int N, M, ans;
	static int[] roomSize;
	static int[][] map, dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}, room;
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		room = new int[N][M];
		roomSize = new int[2501];
		check = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int roomCnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!check[i][j]) {
					bfs(i, j, ++roomCnt);
				}
			}
		}
		int maxSize = 0;
		for(int i = 0; i <= roomCnt; i++) {
			maxSize = Math.max(roomSize[i], maxSize);
		}
		boolean[] visited = new boolean[roomCnt + 1];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[room[i][j]]) {
					solve(i, j, 1);
					visited[room[i][j]] = true;
				}
			}
		}
		System.out.println(roomCnt);
		System.out.println(maxSize);
		System.out.println(ans);
	}
	static boolean inRange(int r, int c) {
		return (r < N && r >= 0 && c < M && c >= 0);
	}
	static void bfs(int r, int c, int roomCnt) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		check[r][c] = true;
		room[r][c] = roomCnt;
		int count = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = cur[0] + dir[i][0];
				int nx = cur[1] + dir[i][1];
				if(inRange(ny, nx) && !check[ny][nx] && (map[cur[0]][cur[1]] & (1 << i)) == 0) {
					q.add(new int[] {ny, nx});
					check[ny][nx] = true;
					room[ny][nx] = roomCnt;
					count++;
				}
			}
		}
		roomSize[roomCnt] = count;
	}
	private static void solve(int r, int c, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] check = new boolean[N][M];
		q.add(new int[] {r, c, 1});
		check[r][c] = true;
		int maxSize = roomSize[room[r][c]];
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = cur[0] + dir[i][0];
				int nx = cur[1] + dir[i][1];
				if(inRange(ny, nx) && !check[ny][nx]) {
					if(room[cur[0]][cur[1]] != room[ny][nx] && cur[2] > 0) {
						q.add(new int[] {ny, nx, cur[2] - 1});
						check[ny][nx] = true;
						maxSize = Math.max(maxSize, roomSize[room[r][c]] + roomSize[room[ny][nx]]);
					} else {
						q.add(new int[] {ny, nx, cur[2]});
						check[ny][nx] = true;
					}
				}
			}
		}
		ans = Math.max(maxSize, ans);
	}
}
