package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14499_주사위굴리기 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuffer sb = new StringBuffer();
		int[] dice = new int[6];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			int command = Integer.parseInt(st.nextToken());
			int[] dicePos = new int[6];	
			switch(command) {
			case 1:
				if( y + 1 < M ) {	// 동
					y++;
					dicePos = new int[] {4, 2, 1, 6, 5, 3};
					break;
				} 
				else continue;
			case 2:
				if( y - 1 >= 0 ) {	// 서
					y--;
					dicePos = new int[] {3, 2, 6, 1, 5, 4};
					break;
				}
				else continue;
			case 3:
				if( x - 1 >= 0 ) {	// 북
					x--;
					dicePos = new int[] {5, 1, 3, 4, 6, 2};
					break;
				}
				else continue;
			case 4:
				if( x + 1 < N ) {	// 남
					x++;
					dicePos = new int[] {2, 6, 3, 4, 1, 5};
					break;
				}
				else continue;
			}
			int[] temp = new int[6];
			for(int j = 0; j < 6; j++) {	// temp에 주사위 값 복사
				temp[j] = dice[j];
			}
			for(int j = 0; j < 6; j++) {	// 주사위 값 재배치
				dice[j] = temp[dicePos[j] - 1];
			}
			if(map[x][y] == 0) {
				map[x][y] = dice[5];
			} else {
				dice[5] = map[x][y];
				map[x][y] = 0;
			}
			if(i != K-1) {
				sb.append(dice[0]).append("\n");
			} else {
				sb.append(dice[0]);
			}
		}
		System.out.print(sb);
	}
}
