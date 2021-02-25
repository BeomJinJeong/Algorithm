package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2527_직사각형 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int left = Math.max(x1,  x2);
			int right = Math.min(c1, c2);
			int up = Math.min(r1, r2);
			int down = Math.max(y1, y2);
			
			int width = right - left;
			int height = up - down;
			
			if(width == 0 && height == 0) System.out.println("c");
			else if(width == 0 || height == 0) System.out.println("b");
			else if(width < 0 || height < 0) System.out.println("d");
			else System.out.println("a");
		}
	}
}
