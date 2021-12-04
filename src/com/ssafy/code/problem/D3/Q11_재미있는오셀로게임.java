package com.ssafy.code.problem.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11_재미있는오셀로게임 {
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			map = new int[N + 2][N + 2];
			map[N/2][N/2] = 1;
			map[N/2 + 1][N/2] = 2;
			map[N/2][N/2 + 1] = 2;
			map[N/2 + 1][N/2 + 1] = 1;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken()); 	// 놓을 우치 가로
				int r = Integer.parseInt(st.nextToken()); 	// 놓을 위치 세로
				int n = Integer.parseInt(st.nextToken());	// 돌 색
				if(map[r][c] == 0) {
					map[r][c] = n;
					if(map[r + 1][c] != map[r][c] && map[r + 1][c] != 0 && checkdown(map[r][c], r, c)) down(map[r][c], r, c);	// 아래
					if(map[r + 1][c - 1] != map[r][c] && map[r + 1][c - 1] != 0 && checkleftDown(map[r][c], r, c)) leftDown(map[r][c], r, c);	// 왼쪽아래
					if(map[r][c - 1] != map[r][c] && map[r][c - 1] != 0 && checkleft(map[r][c], r, c)) left(map[r][c], r, c);	// 왼쪽
					if( map[r - 1][c - 1] != map[r][c] && map[r - 1][c - 1] != 0 && checkleftUp(map[r][c], r, c)) leftUp(map[r][c], r, c);	// 왼쪽위
					if(map[r - 1][c] != map[r][c] && map[r - 1][c] != 0 && checkup(map[r][c], r, c)) up(map[r][c], r, c);	// 위
					if(map[r - 1][c + 1] != map[r][c] && map[r - 1][c + 1] != 0 && checkrightUp(map[r][c], r, c)) rightUp(map[r][c], r, c);	//오른쪽위
					if(map[r][c + 1] != map[r][c] && map[r][c + 1] != 0 && checkright(map[r][c], r, c)) right(map[r][c], r, c);		//오른쪽
					if(map[r + 1][c + 1] != map[r][c] && map[r + 1][c + 1] != 0 && checkrightDown(map[r][c], r, c)) rightDown(map[r][c], r, c);	// 오른쪽아래
				}
			}
			int cntB = 0, cntW = 0;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(map[i][j] == 1) cntB++;
					else if(map[i][j] == 2) cntW++;
				}
			}
			System.out.println("#" + t + " " + cntB + " " + cntW);
		}
	}
	
	private static boolean checkrightDown(int val, int r, int c) {
		for(;; r++, c++) {
			if(map[r + 1][c + 1] == 0) return false;
			if(map[r + 1][c + 1] == val) return true;
		}
	}
	private static boolean checkright(int val, int r, int c) {
		for(;; c++) {
			if(map[r][c + 1] == 0) return false;
			else if(map[r][c + 1] == val) return true;
		}
	}
	private static boolean checkrightUp(int val, int r, int c) {
		for(;; r--, c++) {
			if(map[r - 1][c + 1] == 0) return false;
			else if(map[r - 1][c + 1] == val) return true;
		}
	}
	private static boolean checkup(int val, int r, int c) {
		for(;; r--) {
			if(map[r - 1][c] == 0) return false;
			else if(map[r - 1][c] == val) return true;
		}
	}
	private static boolean checkleftUp(int val, int r, int c) {
		for(;; r--, c--) {
			if(map[r - 1][c - 1] == 0) return false;
			else if(map[r - 1][c - 1] == val) return true;
		}
	}
	private static boolean checkleft(int val, int r, int c) {
		for(;; c--) {
			if(map[r][c - 1] == 0) return false;
			else if(map[r][c - 1] == val) return true;
		}
	}
	private static boolean checkleftDown(int val, int r, int c) {
		for(;; r++, c--) {
			if(map[r + 1][c - 1] == 0) return false;
			else if(map[r + 1][c - 1] == val) return true;
			
		}
	}
	private static boolean checkdown(int val, int r, int c) {
		for( ;; r++) {
			if(map[r + 1][c] == 0) return false;
			else if(map[r + 1][c] == val) return true;
		}
	}
	//--------------------------------------------
	private static void rightDown(int val, int r, int c) {
		for(; map[r + 1][c + 1] != val; r++, c++) {
			map[r + 1][c + 1] = val;
		}
	}
	private static void right(int val, int r, int c) {
		for(; map[r][c + 1] != val; c++) {
			map[r][c + 1] = val;
		}
	}
	private static void rightUp(int val, int r, int c) {
		for(; map[r - 1][c + 1] != val; r--, c++) {
			map[r - 1][c + 1] = val;
		}
	}
	private static void up(int val, int r, int c) {
		for(; map[r - 1][c] != val; r--) {
			map[r - 1][c] = val;
		}
	}
	private static void leftUp(int val, int r, int c) {
		for(; map[r - 1][c - 1] != val; r--, c--) {
			map[r - 1][c - 1] = val;
		}
	}
	private static void left(int val, int r, int c) {
		for(; map[r][c - 1] != val; c--) {
			map[r][c - 1] = val;
		}
	}
	private static void leftDown(int val, int r, int c) {
		for(; map[r + 1][c - 1] != val; r++, c--) {
			map[r + 1][c - 1] = val;
		}
	}
	private static void down(int val, int r, int c) {
		for( ;map[r + 1][c] != val; r++) {
			map[r + 1][c] = val;
		}
	}
}
