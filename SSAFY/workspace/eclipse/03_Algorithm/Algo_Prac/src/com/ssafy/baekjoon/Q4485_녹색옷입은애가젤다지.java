package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Loss{
	int x;
	int y;
	int val;
	public Loss(int x, int y, int val) {
		super();
		this.x = x;
		this.y = y;
		this.val = val;
	}
}
public class Q4485_녹색옷입은애가젤다지 {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = -1;
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) return;
			int[][] map = new int[N][N];
			int[][] tmp = new int[N][N];
			boolean[][] check = new boolean[N][N];
			Queue<Loss> q = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			for(int i = 0; i < N; i++) {
				Arrays.fill(tmp[i], Integer.MAX_VALUE);
			}
			q.add(new Loss(0, 0, map[0][0]));
			check[0][0] = true;
			tmp[0][0] = map[0][0];
			
			while(!q.isEmpty()) {
				Loss cur = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int ny = cur.y + dir[i][0];
					int nx = cur.x + dir[i][1];
					
					if(inRange(ny, nx, N) && cur.val + map[ny][nx] < tmp[ny][nx]) {
						q.add(new Loss(nx, ny, cur.val + map[ny][nx]));
						tmp[ny][nx] = cur.val + map[ny][nx];
					}
				}
			}
			System.out.println("Problem " + t + ": " + tmp[N - 1][N - 1]);
			t++;
		}
	}
	private static boolean inRange(int r, int c, int N) {
		return (r < N && r >= 0 && c < N && c >= 0);
	}
}
