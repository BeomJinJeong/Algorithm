package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int value;
	int width;
	int height;
	public Pos(int value, int width, int height) {
		super();
		this.value = value;
		this.width = width;
		this.height = height;
	}
}
public class Q2178_미로탐색 {
	static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	static Pos[][] map;
	static Queue<Pos> queue;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		queue = new LinkedList<>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Pos[N][M];
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = new Pos(Integer.parseInt(temp[j]), j, i);
			}
		}
		map[0][0].value = 2;
		queue.offer(map[0][0]);
		bfs();
	}
	public static void bfs() {
		while(!queue.isEmpty()) {
			Pos current = queue.poll();
			if(current.width == M-1 && current.height == N-1) break;
			if(current.value != 0) {
				for(int i = 0; i < 4; i++) {
					int ny = current.height + dir[i][0];
					int nx = current.width + dir[i][1];
					
					if( ny < 0 | ny >= N | nx < 0 | nx >= M ) continue;
					if(map[ny][nx].value == 1) {
						map[ny][nx].value += current.value;
						queue.offer(map[ny][nx]);
					}
				}
			}
		}
		System.out.println(map[N-1][M-1].value - 1);
	}
}
