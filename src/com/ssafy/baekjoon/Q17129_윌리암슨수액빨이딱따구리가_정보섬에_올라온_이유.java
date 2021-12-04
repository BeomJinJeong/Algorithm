package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17129_윌리암슨수액빨이딱따구리가_정보섬에_올라온_이유 {
	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int N, M;
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];
		int r = 0, c = 0;
		
		for(int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
				if(map[i][j] == 2) {
					r = i;
					c = j;
				}
			}
		}
		bfs(r, c);
	}
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		check[r][c] = true;
		
		int l = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {				
				int[] cur = q.poll();
				if(map[cur[0]][cur[1]] > 2) {
					System.out.println("TAK");
					System.out.println(l);
					return;
				}
				
				for(int i = 0; i < 4; i++) {
					int dy = cur[0] + dir[i][0];
					int dx = cur[1] + dir[i][1];
					
					if(isEnable(dy, dx) &&!check[dy][dx] && map[dy][dx] != 1) {
						q.add(new int[] {dy, dx});
						check[dy][dx] = true;
					}
				}
			}
			l++;
		}
		System.out.println("NIE");
		return;
	
	}
	static boolean isEnable(int r, int c) {
		if(r < N && r >= 0 && c < M && c >= 0) return true;
		return false;
	}
}
