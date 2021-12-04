package com.ssafy.code.problem.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01_오목판정 {
	static char[][] map;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N + 2][N + 2]; 
			
			for(int i = 1; i < N + 1; i++) {
				String str = br.readLine();
				for(int j = 1; j < N + 1; j++) {
					map[i][j] = str.charAt(j-1);					
				}
			}
			boolean check = false;
			outer : for(int i = 1; i < N + 1; i++) {
				for(int j = 1; j < N + 1; j++) {
					if(map[i][j] != '.') {
						if(map[i-1][j-1] != 'o' && rightDown(map[i][j], i, j)) {
							System.out.println("#" + t + " YES");
							check = true;
							break outer;
						} else if(map[i-1][j] != 'o' && down(map[i][j], i, j)) {
							System.out.println("#" + t + " YES");
							check = true;
							break outer;
						} else if(map[i+1][j-1] != 'o' && rightUp(map[i][j], i, j)) {
							System.out.println("#" + t + " YES");
							check = true;
							break outer;
						} else if(map[i][j-1] != 'o' && right(map[i][j], i, j)) {
							System.out.println("#" + t + " YES");
							check = true;
							break outer;
						}  
					}
				}
			}
			if(!check) System.out.println("#" + t + " NO");
		}
	}
	private static boolean right(char c, int i, int j) {
		int cnt = 1;
		for(;c == map[i][j+1]; j++) {
			cnt++;
		}
		return cnt >= 5;		 
	}
	private static boolean rightUp(char c, int i, int j) {
		int cnt = 1;
		for(;c == map[i-1][j+1]; i--, j++) {
			cnt++;
		}
		return cnt >= 5;
	}
	private static boolean down(char c, int i, int j) {
		int cnt = 1;
		for(;c == map[i+1][j];i++) {
			cnt++;
		}
		return cnt >= 5;
	}
	private static boolean rightDown(char c, int i, int j) {
		int cnt = 1;
		for(;c == map[i+1][j+1];i++, j++) {
			cnt++;
		}
		return cnt >= 5;
	}
}
