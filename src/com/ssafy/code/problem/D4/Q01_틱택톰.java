package com.ssafy.code.problem.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01_틱택톰 {
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		outer : for(int t = 1; t <= T; t++) {
			map = new char[6][6];
			for(int i = 1; i < 5; i++) {
				String str = br.readLine();
				for(int j = 1; j < 5; j++) {
					map[i][j] = str.charAt(j - 1);
				}
			}
			
			// 가로 탐색
			for(int i = 1; i < 5; i++) {
				if(map[1][i] == 'T') {
					if(goDown(2, i, map[2][i], 2)) {
						System.out.println("#" + t + " " + map[2][i] + " won");
						br.readLine();
						continue outer;						
					}
				} else {
					if(goDown(1, i, map[1][i], 1)) {
						System.out.println("#" + t + " " + map[1][i] + " won");
						br.readLine();
						continue outer;
					};
				}
			}
			// 가로 탐색
			for(int i = 1; i < 5; i++) {
				if(map[i][2] == 'T') {
					if(goRight(i, 2, map[i][2], 2)) {
						System.out.println("#" + t + " " + map[i][2] + " won");
						br.readLine();
						continue outer;
					}					
				}
				if(goRight(i, 1, map[i][1], 1)) {
					System.out.println("#" + t + " " + map[i][1] + " won");
					br.readLine();
					continue outer;
				}
			}
			// 왼쪽 위 대각선 탐색
			if(map[1][1] == 'T') {
				if(checkLCrs(2, 2, map[2][2], 2)) {
					System.out.println("#" + t + " " + map[2][2] + " won");
					br.readLine();
					continue outer;					
				}
			} else {
				if(checkLCrs(1, 1, map[1][1], 1)) {
					System.out.println("#" + t + " " + map[1][1] + " won");
					br.readLine();
					continue outer;
				};
			}
			// 오른쪽 위 대각선 탐색
			if(map[1][4] == 'T') {
				if(checkRCrs(2, 3, map[2][3], 2)) {
					System.out.println("#" + t + " " + map[2][3] + " won");
					br.readLine();
					continue outer;
				}				
			} else {
				if(checkRCrs(1, 4, map[1][4], 1)) {
					System.out.println("#" + t + " " + map[1][4] + " won");
					br.readLine();
					continue outer;
				}
			}

			boolean fin = true;
			inner: for(int i = 1; i < 5; i++) {
				for(int j = 1; j < 5; j++) {
					if(map[i][j] == '.') {
						fin = false;
						break inner;
					}
				}
			}
			
			if(fin) System.out.println("#" + t + " Draw");
			else System.out.println("#" + t + " Game has not completed");
			br.readLine();
		}
	}
	public static boolean goDown(int r, int c, int val, int cnt) {
		if(val == '.') return false;
		for(; val == map[r + 1][c] || map[r + 1][c] == 'T'; r++) {
			cnt++;
		}
		return cnt == 4;
	}
	public static boolean goRight(int r, int c, int val, int cnt) {
		if(val == '.') return false;
		for(; val == map[r][c + 1] || map[r][c + 1] == 'T'; c++) {
			cnt++;
		}
		return cnt == 4;
	}
	public static boolean checkLCrs(int r, int c, int val, int cnt) {
		if(val == '.') return false;
		for(; val == map[r + 1][c + 1] || map[r + 1][c + 1] == 'T'; r++, c++) {
			cnt++;
		}
		return cnt == 4;
	}
	public static boolean checkRCrs(int r, int c, int val, int cnt) {
		if(val == '.') return false;
		for(; val == map[r + 1][c - 1] || map[r + 1][c - 1] == 'T'; r++, c--) {
			cnt++;
		}
		return cnt == 4;
	}
	
}
