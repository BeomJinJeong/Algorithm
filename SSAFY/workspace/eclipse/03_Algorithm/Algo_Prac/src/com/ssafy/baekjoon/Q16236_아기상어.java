package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark{
	int y;
	int x;
	public Shark(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}
public class Q16236_아기상어 {
	static int[][] way, map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};	// 거리
	static int N, sharkSize = 2, eatCnt, target_x, target_y, dist;
	static boolean[][] check;
	static Shark s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					s = new Shark(i, j);
					map[i][j] = 0;
				}
			}
		}
		while(true) {
			bfs();
			if(!check()) {
				break;
			}
			s.x = target_x;
			s.y = target_y;
			eatCnt++;
			if(eatCnt == sharkSize) {
				sharkSize++;
				eatCnt = 0;
			}
			map[target_y][target_x] = 0;
			dist += way[target_y][target_x];
		}
		System.out.print(dist);
	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		way = new int[N][N];
		check = new boolean[N][N];
		q.add(new int[] {s.y, s.x});
		check[s.y][s.x] = true;  
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			for(int i = 0; i < 4; i++) {
				int ny = y + dir[i][0];
				int nx = x + dir[i][1];
				if( ny < N && ny >= 0 && nx < N && nx >= 0 && !check[ny][nx]) {
					if(map[ny][nx] > sharkSize) {
						check[ny][nx] = true;
						continue;
					}
					q.offer(new int[] {ny, nx});
					check[ny][nx] = true;
					way[ny][nx] = way[y][x] + 1;
				}
			}
		}
	}
	private static boolean check() {
		ArrayList<int[]> list = new ArrayList<>();
		boolean flag = false;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] < sharkSize && map[i][j] != 0 && way[i][j] != 0) {
					list.add(new int[] {i, j, way[i][j]}); 
					flag = true;
				}
			}
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int diff = o1[2] - o2[2];
				if(diff == 0) {
					diff = o1[0] - o2[0];
					if(diff == 0) {
						return o1[1] - o2[1];
					} else {
						return diff;
					}
				} else {
					return diff;
				}
			}
		});
		if(!flag) {
			return false;
		} else {
			target_y = list.get(0)[0];
			target_x = list.get(0)[1];
			return true;
		}
	}
}
