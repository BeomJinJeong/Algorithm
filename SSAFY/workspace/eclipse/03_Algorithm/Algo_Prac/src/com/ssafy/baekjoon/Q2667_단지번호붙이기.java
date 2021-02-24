package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q2667_단지번호붙이기 {
	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] check;
	static int N, totalCnt, sum;
	static ArrayList<Integer> cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt = new ArrayList<>();
		check = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				map[i][j] = Character.getNumericValue(temp[j]);
			}
		}
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < N; j++) {
				if(dfs(i, j)) {
					totalCnt++;
					cnt.add(sum);
					sum = 0;
				}
			}
		}
		Collections.sort(cnt, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		System.out.println(totalCnt);
		for(int a : cnt) {
			System.out.println(a);
		}
	}
	public static boolean dfs(int r, int c) {
		if(check[r][c]) return false;
		if(map[r][c] == 0) return false;
		check[r][c] = true;
		sum++;
		for(int i = 0; i < 4; i++) {
			int ny = r + dir[i][0];
			int nx = c + dir[i][1];
			if( ny < 0 | ny >= N | nx < 0 | nx >= N ) continue;
			if(!check[ny][nx] && map[ny][nx] == 1) {
				dfs(ny, nx);
				check[ny][nx] = true;
			}
		}
		return true;
	}
}
