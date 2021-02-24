package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q2605_줄세우기 {
	static int[][] line;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		line = new int[N][2];
		for(int i = 0; i < N; i++) {
			line[i][0] = i;	// 아이들 순번
			line[i][1] = i;	// 현재 아이들 순서
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			getLine(Integer.parseInt(st.nextToken()), i);
		}
		Arrays.sort(line, new Comparator<int[]>() { // 줄 순서대로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		for(int[] a : line) {
			System.out.print(a[0] + 1 + " ");
		}
	}
	private static void getLine(int n, int i) {
		for(int j = 0; j < line.length; j++) {	// 뒤로 밀려날 친구들 순서 한 칸씩 증가
			if(line[j][1] >= (line[i][1] - n) && line[j][1] < line[i][1]) line[j][1]++;
		}
		line[i][1] -= n;	// 뽑은 번호만큼 앞으로 이동
	}
}
