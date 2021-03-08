package com.ssafy.code.problem.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Q3_방향전환 {
	public static int x1, x2, y1, y2, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			go(true);
			go(false);
			System.out.println("#" + t + " " + min);
			min = Integer.MAX_VALUE;
		}
	}
	private static void go(boolean flag) {
		int x = x1;
		int y = y1;
		int cnt = 0;
		while(true) {
			if(x == x2 && y == y2) {
				min = Math.min(cnt,  min);
				return;
			} 
			if(flag) {
				if(x < x2) x++;
				else x--;
				cnt++;
				flag = false;
			} else {
				if(y < y2) y++;
				else y--;
				cnt++;
				flag = true;
			}
		}
	}
}
