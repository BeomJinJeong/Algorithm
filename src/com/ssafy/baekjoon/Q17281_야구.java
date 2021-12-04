package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q17281_야구 {
	static int[][] result, list;
	static boolean[] check;
	static int N, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[9][N];
		StringTokenizer st = null;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				list[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		result = new int[9][N];
		check = new boolean[9];
		result[3] = list[0];
		check[0] = true;
		perm(0);
		System.out.println(ans);
	}
	private static void perm(int cnt) {
		if(cnt == 9) {
			play();
			return;
		}
		for(int i = 1; i < 9; i++) {
            if(!check[i]) {
            	if(cnt == 3) {
            		perm(cnt + 1);
            	} else {            		
            		result[cnt] = list[i];
            		check[i] = true;
            		perm(cnt + 1);
            		check[i] = false;
            	}
            }
        }
	}
	private static void play() {
		int outCnt = 0, score = 0, inning = 0;
		ArrayList<Integer> ground = new ArrayList<>();
		int playerIdx = 0, inningIdx = 0;
		
		while(inning < N) {
			int size = ground.size();
			switch(result[playerIdx][inningIdx]) {
			case 1:
				for(int i = size - 1; i >= 0; i--) {
					ground.set(i, ground.get(i) + 1);
					if(ground.get(i) >= 4) {
						ground.remove(i);
						score++;
					}
				}
				ground.add(1);
				break;
			case 2:
				for(int i = size - 1; i >= 0; i--) {
					ground.set(i, ground.get(i) + 2);
					if(ground.get(i) >= 4) {
						ground.remove(i);
						score++;
					}
				}
				ground.add(2);
				break;
			case 3:
				for(int i = size - 1; i >= 0; i--) {
					ground.set(i, ground.get(i) + 3);
					if(ground.get(i) >= 4) {
						ground.remove(i);
						score++;
					}
				}
				ground.add(3);
				break;
			case 4:
				score += ground.size() + 1;
				ground.clear();
				break;
			case 0:
				outCnt++;
				break;
			}
			if(outCnt == 3) {
				inningIdx++;
				inning++;
				outCnt = 0;
				ground.clear();
			}
			if(playerIdx == 8) playerIdx = 0;
			else playerIdx++;
		}
		ans = Math.max(score, ans);
	}
}
