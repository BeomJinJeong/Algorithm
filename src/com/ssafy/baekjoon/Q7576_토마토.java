package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int i; 
	int j;
	int value;
	public Tomato(int i, int j, int value) {
		super();
		this.i = i;
		this.j = j;
		this.value = value;
	}
}
public class Q7576_토마토 {
	static Tomato[][] arr;
	static Queue<Tomato> q; 
	static int remain = 0, H, W, day = 0;
	static int dir[][] = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new Tomato[H][W];
		q = new LinkedList<>();
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				arr[i][j] = new Tomato(i, j, Integer.parseInt(st.nextToken()));
				if(arr[i][j].value == 0) remain++;
				else if(arr[i][j].value == 1) {
					q.offer(arr[i][j]);
				}
			}
		}
		if(remain == 0) {
			System.out.println(0);
			return;
		}
		new Q7576_토마토().bfs();
		if(remain == 0) {
			System.out.println(day - 1);
			return;
		} else {
			System.out.println(-1);
			return;
		}
	}
	public void bfs() {
		while (!q.isEmpty()) {
			Tomato current = q.poll();
			if(current.value != 0) {
				for(int i = 0; i < 4; i++) {
					int ny = current.i + dir[i][0];
					int nx = current.j + dir[i][1];
					
					if( ny < 0 | ny >= H | nx < 0 | nx >= W ) continue;
					
					if(arr[ny][nx].value == 0) {
						int a = current.value;
						arr[ny][nx].value = a + 1;
						day = Math.max(day, a+1);
						q.offer(arr[ny][nx]);
						remain--;
					}
					if(remain == 0) break;
				}
			}
			if(remain == 0) break;
		} 
		
	}
}
