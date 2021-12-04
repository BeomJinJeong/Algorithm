package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10158_개미 {
	static int W, H, t;
	static int[][] dir = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		move(p, q, 0);
	}
	static void move(int x, int y, int direct) { // 0 : 오른쪽하강  1 : 왼쪽하강  2: 왼쪽상승  3 : 오른쪽상승
		if(t == 0) {
			System.out.println(x + " " + y);
			return;
		}
		for(int i = direct; i < 4; i++) {
			int nx = x + dir[i][1];
			int ny = y + dir[i][0];
			
			switch(i) {
			case 0 :
				if( ny > H ) {
					i = 2; continue;
				} else if( nx > W ) {
					i = 0; continue;
				}
				break;
			case 1 :
				if( nx < 0 ) {
					i = -1; continue; 
				} else if( ny > H ) {
					i = 1; continue;
				}
				break;
			case 2 :
				if ( ny < 0 ) {
					i = 0; continue;
				} else if ( nx < 0 ) {
					i = 2; continue;
				}
				break;
			case 3 :
				if( nx > W ) {
					i = 1; continue;
				} else if( ny < 0 ) {
					i = -1; continue;
				}
				break;
			}
			
			t--;
			move(nx, ny, i);
			return;
		}
	}
}
