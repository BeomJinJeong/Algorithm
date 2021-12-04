package com.ssafy.SWA.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q5_무선충전 {
	static int M, A, cnt;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[] wayA, wayB;
	static ArrayList<int[]> list;
	static boolean[] inA, inB;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());	// 데이터 길이
			A = Integer.parseInt(st.nextToken());	// BC의 갯수
			wayA = new int[M + 1];
			wayB = new int[M + 1];
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				wayA[i] = Integer.parseInt(st.nextToken());
			}			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				wayB[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int[] temp = new int[4];
				for(int j = 0; j < 4; j++) {
					temp[j] = Integer.parseInt(st.nextToken());
				}
				list.add(temp);
			}
			solve();
		}
	}
	private static void solve() {
		int[] posA = {1, 1};
		int[] posB = {10, 10};
		int sum = 0;
		for(int i = 0; i <= M; i++) {
			switch(wayA[i]) {
			case 1:
				posA[1]--;
				break;
			case 2:
				posA[0]++;
				break;
			case 3:
				posA[1]++;
				break;
			case 4:
				posA[0]--;
				break;
			}			
			switch(wayB[i]) {
			case 1:
				posB[1]--;
				break;
			case 2:
				posB[0]++;
				break;
			case 3:
				posB[1]++;
				break;
			case 4:
				posB[0]--;
				break;
			}
			check(posA, posB);
			
			// 겹치는거 생각해서 계산하기
			// 해야됨
		}
		System.out.println(sum);
	}
	private static void check(int[] posA, int[] posB) {
		boolean a = false, b = false;
		cnt = 0;
		inA = new boolean[A];
		inB = new boolean[A];
		for(int i = 0; i < A; i++) {
			int[] temp = new int[] {list.get(i)[0], list.get(i)[1]};
			if(getDist(temp, posA) <= list.get(i)[2]) {
				inA[i] = true;
				if(!a) {
					cnt++;
					a = true;
				}
			}
			if(getDist(temp, posB) <= list.get(i)[2]) {
				inB[i] = true;
				if(!b){
					cnt++;
					b = false;
				}
			}
		}
	}
	private static int getDist(int[] posBC, int[] posTar) {
		return Math.abs(posBC[0] - posTar[0]) + Math.abs(posBC[1] - posTar[1]);
	}
}
