package com.ssafy.SWA.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6_활주로건설 {
	static int N, X, map[][], tmap[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			tmap = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tmap[j][i] = map[i][j];
				}
			}
			System.out.println("#" + t + " " + process());
		}
	}
	private static int process() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(makeRoad(map[i])) cnt++;
			if(makeRoad(tmap[i])) cnt++;
		}
		return cnt;
	}
	private static boolean makeRoad(int[] road) {
		int beforeHeight = road[0], size = 0;
		int j = 0;
		while(j < N) {
			if(beforeHeight == road[j]) {
				++size;
				++j;
			} else if(beforeHeight + 1 == road[j]) {	// 오르막 설치 가능 판단
				if(size < X) return false; // 경사로 설치 불가
				beforeHeight++;
				size = 1;
				++j;
			} else if(beforeHeight - 1 == road[j]) {	// 내리막 경사로 설치 가능한지 판단ㄷ
				int count = 0;
				for(int k = j; k < N; k++) {
					if(road[k] != beforeHeight - 1) break;
					if(++count == X) break;
				}
				if(count < X) return false;	// 경사로 설치 불가
				beforeHeight--;
				size = 0;
				j += X;
			} else {
				return false;
			}
		}
		return true;
	}
}