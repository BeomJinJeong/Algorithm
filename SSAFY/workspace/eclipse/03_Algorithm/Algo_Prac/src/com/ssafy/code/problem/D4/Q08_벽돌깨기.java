package com.ssafy.code.problem.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q08_벽돌깨기 {
	static int W, H, N, total, ans = Integer.MAX_VALUE;
	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[] height, result;
	static boolean[] hCheck;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			height = new int[W];
			result = new int[N];
			hCheck = new boolean[W];
			total = 0;
			ans = Integer.MAX_VALUE;
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] != 0) {
						total++;
						if(height[j] == 0 && !hCheck[j]) {
							height[j] = i;
							hCheck[j] = true;
						}
					}
				}
			}
			perm(0);
			System.out.println("#" + t + " " + ans);
		}
	}
	private static void perm(int cnt) {
		if(cnt == N) {
			int[][] tmp = new int[H][W];
			int[] tHeight = new int[W];
			
			System.arraycopy(height, 0, tHeight, 0, W);			
			for(int i = 0; i < H; i++) {
				System.arraycopy(map[i], 0, tmp[i], 0, W);
			}
			int sum = 0;
			for(int a : result) {
				shoot(a, tmp, tHeight);
			}
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(tmp[i][j] != 0) sum++;
				}
			}
			ans = Math.min(ans, sum);
			return;
		}
		for(int i = 0; i < W; i++) {
			result[cnt] = i;
			perm(cnt + 1);
		}
	}
	private static void shoot(int w, int[][] tmp, int[] tH) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] check = new boolean[H][W];
		q.add(new int[] {tH[w], w});
		check[tH[w]][w] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();			
			int range = tmp[cur[0]][cur[1]];
			tmp[cur[0]][cur[1]] = 0;
			if(tH[cur[1]] + 1 < H) {				
				tH[cur[1]]++;
			}
			
			for(int i = 0; i < 4; i++) {
				for(int j = 1; j < range; j++) {
					int ny = cur[0] + dir[i][0] * j;
					int nx = cur[1] + dir[i][1] * j;
					
					if(inRange(ny, nx) && tmp[ny][nx] != 0 && !check[ny][nx]) {
						q.add(new int[] {ny, nx});
						check[ny][nx] = true;
					}
				}
			}
		}		
		goDown(tmp);
	}
	private static void goDown(int[][] tmp) {
		for(int i = H - 1; i >= 0; i--) {
			for(int j = W - 1; j >= 0; j--) {
				if(tmp[i][j] == 0) {
					for(int k = i - 1; k >= 0; k--) {
						if(tmp[k][j] != 0) {
							tmp[i][j] = tmp[k][j];
							tmp[k][j] = 0;
							break;
						}
					}
				}
			}
		}
	}
	private static boolean inRange(int r, int c) {
		return (r < H && r >= 0 && c < W && c >= 0);
	}
}
