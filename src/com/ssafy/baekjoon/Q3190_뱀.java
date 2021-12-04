package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q3190_뱀 {
	static class turn{
		int time;
		char d;
		public turn(int time, char d) {
			super();
			this.time = time;
			this.d = d;
		}
	}
	static int N, K, L, ans;
	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static turn[] t;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r  = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
		L = Integer.parseInt(br.readLine());
		t = new turn[L];
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			t[i].time = Integer.parseInt(st.nextToken());
			t[i].d = st.nextToken().charAt(0);
		}
		
	}
	private static void play() {
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] {0, 0});
		int time = 1, idx = 0, direct = 1;
		
		while(true) {			
			if(time == t[idx].time) {
				switch(direct) {
				case 0: 
					if(t[idx].d == 'D') direct = 1;
					else direct = 3; 
					break;		
				case 1: 
					if(t[idx].d == 'D') direct = 2;
					else direct = 0; 
					break;					
				case 2: 
					if(t[idx].d == 'D') direct = 3;
					else direct = 1; 
					break;					
				case 3: 
					if(t[idx].d == 'D') direct = 0;
					else direct = 2; 
					break;					
				}
				int r = list.get(0)[0] + dir[direct][0];
				int c = list.get(0)[1] + dir[direct][1];
				list.add(0, new int[] {r, c});
			} else {
				
			}
			++time;
		}
	}
}
