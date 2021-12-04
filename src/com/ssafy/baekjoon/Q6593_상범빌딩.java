package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q6593_상범빌딩 {
	static int L, R, C;
	static int[][] dir = {{0, 0, -1}, {0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {1, 0, 0}, {-1, 0, 0}};
	static int fromX, fromY, fromF, toX, toY, toF;
	static char[][][] building; 
	static int[][][] num;
	static boolean result = false;
	static boolean[][][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L == 0) break;
			building = new char[L][R][C];
			num = new int[L][R][C];
			check = new boolean[L][R][C];
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R; j++) {
					String str = br.readLine();
					for(int k = 0; k < C; k++) {
						building[i][j][k] = str.charAt(k);
						if(building[i][j][k] == 'S') {
							fromX = k; fromY = j; fromF = i;
						} else if(building[i][j][k] == 'E') {
							toX = k; toY = j; toF = i;
						}
					}
				}
				br.readLine();
			}
			bfs();
			if(result) System.out.println("Escaped in " + num[toF][toY][toX] + " minute(s).");
			else System.out.println("Trapped!");
			result = false;
			
		}
	}
	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {fromF, fromY, fromX});
		check[fromF][fromY][fromX] = true;
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for(int i = 0; i < 6; i++) {
				int nx = current[2] + dir[i][2];
				int ny = current[1] + dir[i][1];
				int nf = current[0] + dir[i][0];
				
				if( nx < 0 | nx >= C | ny < 0 | ny >= R | nf < 0 | nf >= L ) continue;
				
				if(building[nf][ny][nx] == '.') {
					if(!check[nf][ny][nx]) {
						queue.offer(new int[] {nf, ny, nx});
						check[nf][ny][nx] = true;
						num[nf][ny][nx] = num[current[0]][current[1]][current[2]] + 1;
					}
				} else if(building[nf][ny][nx] == 'E') {
					num[nf][ny][nx] = num[current[0]][current[1]][current[2]] + 1;
					result = true;
					break;
				}
			}
		}
		
	}
}
