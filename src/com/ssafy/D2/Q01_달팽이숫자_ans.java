package com.ssafy.D2;

import java.util.Scanner;

public class Q01_달팽이숫자_ans {

	static int T;
	static int N;
	static int[][] snail;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) {

		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			N = scann.nextInt();
			snail = new int[N][N];

			int y = 0;
			int x = 0;
			int d = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					snail[y][x] = i * N + j + 1;
					// 사방 탐색을 이용한 구현
					if (d == 0) {
						if (!(x + dx[d] < N && snail[y][x + dx[d]] == 0)) {
							d = 1;
						}
					} else if (d == 1) {
						if (!(y + dy[d] < N && snail[y + dy[d]][x] == 0)) {
							d = 2;
						}
					} else if (d == 2) {
						if (!(x + dx[d] >= 0 && snail[y][x + dx[d]] == 0)) {
							d = 3;
						}
					} else if (d == 3) {
						if (!(y + dy[d] >= 0 && snail[y + dy[d]][x] == 0)) {
							d = 0;
						}
					}
					x += dx[d];
					y += dy[d];
				}
			}
			System.out.println("#" + iT);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();

		}
		scann.close();
	}
}
