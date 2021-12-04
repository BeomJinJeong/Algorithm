package com.ssafy.SWA.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4_탈주범검거 {
	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int N, M, R, C, L;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 세로
			M = Integer.parseInt(st.nextToken());	// 가로
			R = Integer.parseInt(st.nextToken());	// 처음 세로 위치
			C = Integer.parseInt(st.nextToken());	// 처음 가로 위치
			L = Integer.parseInt(st.nextToken());	// 소요 시간
			map = new int[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + t + " " + bfs());
		}
	}
	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] check = new boolean[N][M];
		q.add(new int[] {R, C});
		check[R][C] = true;
		int count = 1;
		int limit = 1;
		
		while(!q.isEmpty()) {
			
			if(limit == L) break;
			int size = q.size();
			for(int s = 0; s < size; s++) {				
				int[] cur = q.poll();
				int x = cur[1];
				int y = cur[0];
				
				boolean[] tmp = isPossibleDir(map[cur[0]][cur[1]]);
				for(int i = 0; i < 4; i++) {
					int ny = y + dir[i][0];
					int nx = x + dir[i][1];
					
					if(isRange(ny, nx)) {						
						boolean[] tmp2 = isPossibleDir(map[ny][nx]);
						
						if(map[ny][nx] != 0 && !tmp[i] && !tmp2[(i + 2) % 4] && !check[ny][nx]) {
							q.add(new int[] {ny, nx});
							check[ny][nx] = true;
							count++;
						}
					}
				}
			}
			limit++;
		}
		return count;
	}
	private static boolean isRange(int r, int c) {
		return (r < N && r >= 0 && c < M && c >= 0);
	}
	private static boolean[] isPossibleDir(int status) {
		boolean[] isPossible = new boolean[4];
		switch(status) {
		case 1:
			isPossible[0] = false;
			isPossible[1] = false;
			isPossible[2] = false;
			isPossible[3] = false;
			break;
		case 2:
			isPossible[0] = false;
			isPossible[1] = true;
			isPossible[2] = false;
			isPossible[3] = true;
			break;
		case 3:
			isPossible[0] = true;
			isPossible[1] = false;
			isPossible[2] = true;
			isPossible[3] = false;
			break;
		case 4:
			isPossible[0] = false;
			isPossible[1] = false;
			isPossible[2] = true;
			isPossible[3] = true;
			break;
		case 5:
			isPossible[0] = true;
			isPossible[1] = false;
			isPossible[2] = false;
			isPossible[3] = true;
			break;
		case 6:
			isPossible[0] = true;
			isPossible[1] = true;
			isPossible[2] = false;
			isPossible[3] = false;
			break;
		case 7:
			isPossible[0] = false;
			isPossible[1] = true;
			isPossible[2] = true;
			isPossible[3] = false;
			break;
		}
		return isPossible;
	}
}
