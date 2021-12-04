package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus {
	int y; 
	int x;
	public Virus(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}
public class Q17142_연구소3 {
	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] check;
	static int N, M, vCnt, min = Integer.MAX_VALUE, tCnt, tSum;
	static Queue<Virus> q;
	static ArrayList<Virus> list;
	static Virus[] res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		list = new ArrayList<>();
		res = new Virus[M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					list.add(new Virus(i, j));
					vCnt++;
				}
			}
		}
		comb(0, 0);
		if(tCnt == tSum) {
			System.out.println(-1);
			return;
		}
		System.out.println(min);
	}
	private static void comb(int cnt, int start) {
		if(cnt == M) {
			int tmp = bfs(res);
			if(tmp != -1) {
				min = Math.min(bfs(res), min);				
			}
			tCnt++;
			return;
		}
		for(int i = start; i < vCnt; i++) {
			res[cnt] = list.get(i);
			comb(cnt + 1, i + 1);
		}
	}
	private static int bfs(Virus[] arr) {
		int max = -1;
		q = new LinkedList<>();
		check = new boolean[N][N];
		int[][] cnt = new int[N][N];
		for(int i = 0; i < arr.length; i++) {
			q.add(arr[i]);
			check[arr[i].y][arr[i].x] = true;
			cnt[arr[i].y][arr[i].x] = 1;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) cnt[i][j] = -1;
			}
		}
		while(!q.isEmpty()) {
			Virus cur = q.poll();
			
			for(int i = 0; i < 4; i++) {				
				int ny = cur.y + dir[i][0];
				int nx = cur.x + dir[i][1];
				if( nx < N && nx >= 0 && ny < N && ny >= 0  && !check[ny][nx] && map[ny][nx] != 1 ) {
					if(map[ny][nx] == 2) {
						q.offer(new Virus(ny, nx));
						check[ny][nx] = true;
						cnt[ny][nx] = cnt[cur.y][cur.x];
					} else if(map[ny][nx] == 0) {
						q.offer(new Virus(ny, nx));
						check[ny][nx] = true;
						cnt[ny][nx] = cnt[cur.y][cur.x] + 1; 
					}
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(cnt[i][j] == 0) {
					tSum++;
					return -1;
				}
				if(max < cnt[i][j]) {
					max = cnt[i][j];
				} 
			}
		}
		System.out.println(0);
		return max - 1;
	}
}
