package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17472_다리만들기2 {
	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}, list;
	static int N, M, islandCnt = 2, INF = 9999999;
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		check = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) 
			for(int j = 0; j < M; j++) 				
				if(bfs(i, j)) 
					islandCnt++;	
		list = new int[islandCnt -2][islandCnt -2];
		for(int[] a : list) {
			Arrays.fill(a, INF);
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				getMinLength(i, j);
			}
		}
		prim();
	}
	private static void prim() {
		islandCnt -= 2;
		boolean[] visited = new boolean[islandCnt];
		int[] minEdge = new int[islandCnt];
		Arrays.fill(minEdge, INF);
		int result = 0;
		minEdge[0] = 0;
		for(int c = 0; c < islandCnt; c++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for(int i = 0; i < islandCnt; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			if(min == INF) {
				result = -1;
				break;
			}
			result += min;
			visited[minVertex] = true;
			
			for(int i = 0; i < islandCnt; i++) {
				if(!visited[i] && list[minVertex][i] != 0 && minEdge[i] > list[minVertex][i]){
					minEdge[i] = list[minVertex][i];
				}
			}
			
		}
		System.out.println(result);		
	}
	private static void getMinLength(int r, int c) {
		if(map[r][c] == 0) return;
		
		for(int i = 0; i < 4; i++) {
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {r, c, 0});
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int ny = cur[0] + dir[i][0];
				int nx = cur[1] + dir[i][1];
				if(ny < N && ny >= 0 && nx < M && nx >= 0) {
					if(map[ny][nx] == 0) {
						q.add(new int[] {ny, nx, cur[2] + 1});
					} else if(map[ny][nx] != map[r][c]) {
						int min = Math.min(list[map[r][c] -2][map[ny][nx] -2], cur[2]);
						if(min > 1) list[map[r][c] -2][map[ny][nx] -2] = min;
					}
				}
			}
		}
	}
	private static boolean bfs(int r, int c) {	// 섬 구분 bfs
		if(check[r][c] || map[r][c] == 0) return false;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		check[r][c] = true;
		map[r][c] = islandCnt;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			map[cur[0]][cur[1]] = islandCnt;
			for(int i = 0; i < 4; i++) {
				int ny = cur[0] + dir[i][0];
				int nx = cur[1] + dir[i][1];
				if(nx < M && ny < N && nx >= 0 && ny >= 0 && !check[ny][nx] && map[ny][nx] == 1) {
					q.offer(new int[] {ny, nx});
					check[ny][nx] = true;
				}
				
			}
		}
		return true;
	}
}
