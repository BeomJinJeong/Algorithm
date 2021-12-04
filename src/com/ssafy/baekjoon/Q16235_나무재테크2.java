package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q16235_나무재테크2 {	// 인덱스 확인. 오류
	static int N, M, K;
	static int[][] map, grow, dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static ArrayList<Integer>[][] treeAge;
	static ArrayList<int[]> treePos, dead;
	
	@SuppressWarnings("unchecked")
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
		treeAge = new ArrayList[N][N];	// 나무 저장
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				treeAge[i][j] = new ArrayList<>();
			}
		}
		treePos = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			treePos.add(new int[] {r, c});
			int age = Integer.parseInt(st.nextToken());
			treeAge[r][c].add(age);
		}
		for(int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(treePos.size());
	}
	private static void spring() {
		dead = new ArrayList<>();	// 죽은 나무 리스트
		
		int size = treePos.size();
		for(int i = size - 1; i >= 0; i--) {
			int r = treePos.get(i)[0];
			int c = treePos.get(i)[1];
			Collections.sort(treeAge[r][c]);
			
			int ageSize = treeAge[r][c].size();
			for(int j = 0; j < ageSize; j++) {				
				if(grow[r][c] < treeAge[r][c].get(j)) {	// 양분 모자라면
					dead.add(new int[] {r, c});	// 죽은나무 리스트에 추가
					treeAge[r][c].remove(j);	// 나무 삭제
					treePos.remove(j);
					continue;
				}
				grow[r][c] -= treeAge[r][c].get(j);
				treeAge[r][c].set(j, treeAge[r][c].get(j) + 1);
			}
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
		
		int size = treePos.size();
		for(int i = 0; i < size; i++) {
			int r = treePos.get(i)[0];
			int c = treePos.get(i)[1];
			
			int ageSize = treeAge[r][c].size();
			for(int j = 0; j < ageSize; j++) {				
				if(treeAge[r][c].get(j) % 5 == 0) {
					for(int k = 0; k < 8; k++) {
						int ny = r + dir[k][0];
						int nx = c + dir[k][1];
						if( nx < N && nx >= 0 && ny < N && ny >= 0) {
							treePos.add(new int[] {ny, nx});
							treeAge[r][c].add(1);
						}
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
