package com.ssafy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q07_파핑파핑지뢰찾기 {
	static int N;
	static char[][] map;
	static int[][] arr, dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static boolean[][] check; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			arr = new int[N][N];
			check = new boolean[N][N];			
			int ans = 0;
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '*') {
						for(int k = 0; k < 8; k++) {
							int ny = i + dir[k][0];
							int nx = j + dir[k][1];
							if(ny < N && ny >= 0 && nx < N && nx >= 0 && map[ny][nx] == '.') {								
								arr[ny][nx]++;
							}
						}
					}
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!check[i][j] && map[i][j] == '.' && arr[i][j] == 0) {						
						bfs(i, j);
						ans++;
					}
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '.' && !check[i][j] && arr[i][j] != 0) ans++;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
		
	}
	private static void bfs(int r, int c) {			
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});		
		check[r][c] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s < size; s++) {				
				int[] cur = q.poll();
				
				if(arr[cur[0]][cur[1]] != 0) continue;
				
				for(int d = 0; d < 8; d++) {
					int ny = cur[0] + dir[d][0];
					int nx = cur[1] + dir[d][1];
					
					if(ny < N && ny >= 0 && nx < N && nx >= 0 && !check[ny][nx] && map[ny][nx] == '.') {
						q.add(new int[] {ny, nx});
						check[ny][nx] = true;
					}
				}
			}
		}
	}
}
