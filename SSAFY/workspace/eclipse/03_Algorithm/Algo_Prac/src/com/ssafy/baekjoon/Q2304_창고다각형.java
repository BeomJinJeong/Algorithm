package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q2304_창고다각형 {
	static int N, maxIdx, area, max = 0;
	static ArrayList<int[]> list;
	static int[] height;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			if(list.get(i)[1] > max) {
				max = list.get(i)[1];
				maxIdx = list.get(i)[0];	// 최고 높이의 인덱스
			}
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		getArea();
		for(int a : height) {
			area += a;
		}
		System.out.println(area);
	}
	private static void getArea() {
		height = new int[list.get(list.size() - 1)[0] + 1];
		for(int i = 0; i < list.size(); i++) {
			height[list.get(i)[0]] = list.get(i)[1];
		}
		int idx = list.get(0)[0];	// 처음부터 최고 높이의 인덱스까지  -> 상승하는 모습
		for(int i = list.get(0)[0] + 1; i <= maxIdx; i++) {
			if(height[i] >= height[idx]) {
				for(int j = idx + 1; j < i; j++) {
					height[j] = height[idx];
				}
				idx = i;
			} 
		}
		idx = list.get(list.size() - 1)[0];		// 끝에서부터 최고 높이의 인덱스까지 -> 상승하는 모습
		for(int i = list.get(list.size() - 1)[0] - 1; i >= maxIdx; i--) {
			if(height[i] >= height[idx]) {
				for(int j = idx - 1; j > i; j--) {
					height[j] = height[idx];
				}
				idx = i;
			}
		}
	}
}
