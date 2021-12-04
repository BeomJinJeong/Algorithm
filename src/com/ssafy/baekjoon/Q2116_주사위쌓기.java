package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2116_주사위쌓기 {
	static int[][] dice;
	static int N, max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 6; j++) {	// 4번째, 5번째의 값을 바꿔 저장
				if(j == 3) dice[i][4] = Integer.parseInt(st.nextToken());
				else if(j == 4) dice[i][3] = Integer.parseInt(st.nextToken());
				else dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < 6; i++) {	// 맨 밑의 값을 6개 다 해봐야하므로
			solve(dice[0][i], 0, 0);
		}
		System.out.println(max);
	}
	public static void solve(int down, int lev, int sum) {
		if(lev >= N) {	// 주사위 다 쌓으면
			max = Math.max(sum, max);
			return;
		}
		int up = 0, maxSide = 0;	// 윗 면 (다음 주사위의 아랫면), 옆면의 최댓값
		for(int i = 0; i < 6; i++) {
			if(dice[lev][i] == down) {	// 아랫면에서 마주보고 있는 값 
				up = dice[lev][5 - i];
				break;
			}
		}
		for(int i = 0; i < 6; i++) {
			if(dice[lev][i] == down || dice[lev][i] == up) continue;	// 위아래 건너뛰고
			maxSide = Math.max(dice[lev][i], maxSide);	// 최댓값 구하기 
		}
		sum += maxSide;
		solve(up, lev + 1, sum);
	}
}
