package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q16235_나무재테크 {
	static int N, M, K;
	static int[][] map, grow, dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static ArrayList<int[]> list, dead;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 맵 크기
		M = Integer.parseInt(st.nextToken());	// 나무 갯수
		K = Integer.parseInt(st.nextToken());	// 몇 년이 지난 후
		map = new int[N][N];	// 기계가 주는 양분의 양
		grow = new int[N][N];	// 현재 땅의 양분
		for(int i = 0; i < N; i++) {
			Arrays.fill(grow[i], 5);
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	// 기계가 주는 비료 양
			}
		}
		list = new ArrayList<>();	// 나무 저장
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			list.add(new int[] {r, c, age});
		}
		for(int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(list.size());
	}
	private static void spring() {
		dead = new ArrayList<>();	// 죽은 나무 리스트
		Collections.sort(list, new Comparator<int[]>() {	// 어린 나이 나무들이 먼저 양분 섭취하게 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[2] - o1[2];
			}
		});
		
		int size = list.size();
		for(int i = size - 1; i >= 0; i--) {
			int r = list.get(i)[0];
			int c = list.get(i)[1];
			if(grow[r][c] < list.get(i)[2]) {	// 양분 모자라면
				dead.add(list.get(i));	// 죽은나무 리스트에 추가
				list.remove(i);	// 나무 삭제
				continue;
			}
			grow[r][c] -= list.get(i)[2];
			list.get(i)[2]++;
		}
	}
	private static void summer() {
		for(int i = 0; i < dead.size(); i++) {
			int r = dead.get(i)[0];
			int c = dead.get(i)[1];
			grow[r][c] += (dead.get(i)[2] / 2);
		}
	}
	private static void fall() {
		int size = list.size();
		for(int i = 0; i < size; i++) {
			if(list.get(i)[2] % 5 == 0) {
				for(int j = 0; j < 8; j++) {
					int ny = list.get(i)[0] + dir[j][0];
					int nx = list.get(i)[1] + dir[j][1];
					if( nx < N && nx >= 0 && ny < N && ny >= 0) {
						list.add(new int[] {ny, nx, 1});
					}
				}
			}
		}
	}
	private static void winter() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				grow[i][j] += map[i][j];
			}
		}
	}
}
