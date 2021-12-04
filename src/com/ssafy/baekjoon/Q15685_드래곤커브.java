package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15685_드래곤커브 {
	static int[] dy = {0, -1, 0, 1};	// 우, 상, 좌, 하
	static int[] dx = {1, 0, -1, 0};
	static int[][] map = new int[101][101];
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());		// 방향
			int g = Integer.parseInt(st.nextToken());		// 세대
			ArrayList<Integer> list = new ArrayList<>();
			
			list.add(d);
			for(int j = 0; j < g; j++) {	// 세대 반복
				int size = list.size();
				for(int k = size - 1; k >= 0; k--) {		// 최근에 그린 방향부터 처음으로 진행. 
					list.add((list.get(k) + 1) % 4);		// 반시계 방향으로 꺾어서 방향 추가
				}
			}
			map[y][x] = 1;
			
			for(int j = 0; j < list.size(); j++) {			// 방향대로 맵에 마킹
				int point = list.get(j);
				
				x += dx[point];
				y += dy[point];
				
				if( x >= 0 && x < 101 && y >= 0 && y < 101 ) map[y][x] = 1;
			}
		}
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if( map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
