package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q12869_뮤탈리스크 {	
	static int ans = Integer.MAX_VALUE;
	static int[] arr;
	static int[][] damage = {{-9, -3, -1}, {-9, -1, -3}, {-3, -9, -1}, {-3, -1, -9}, {-1, -9, -3}, {-1, -3, -9}};
	static boolean[][][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[3];
		check = new boolean[61][61][61];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(arr, 0);
		System.out.println(ans);
	}
	private static void dfs(int[] arr, int cnt) {
		if(arr[0] <= 0 && arr[1] <= 0 && arr[2] <= 0) {
			ans = Math.min(ans, cnt);
			return;
		}		
		if(cnt > ans) return;
		Arrays.sort(arr);
		
		int temp = arr[0];
		arr[0] = arr[2];
		arr[2] = arr[1];
		arr[1] = arr[2];
		arr[2] = temp;
		
		arr[0] = Math.max(0, arr[0]);
		arr[1] = Math.max(0, arr[1]);
		arr[2] = Math.max(0, arr[2]);
						
		if(!check[arr[0]][arr[1]][arr[2]]) check[arr[0]][arr[1]][arr[2]] = true;
		else return;
		
		for(int i = 0; i < 6; i++) {
			int[] tmp = new int[3];
			tmp[0] = arr[0] + damage[i][0];
			tmp[1] = arr[1] + damage[i][1];
			tmp[2] = arr[2] + damage[i][2];
			dfs(tmp, cnt + 1);
		}
	}
}
