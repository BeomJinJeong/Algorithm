package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q2170_선긋기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int a = 0, b = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list.add(new int[] {a, b});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				else return o1[0] - o2[0];
			}			
		});
		
		int max = list.get(0)[1];
		int min = list.get(0)[0];
		int sum = max - min;
		
		for(int i = 1; i < N; i++) {
			if(min <= list.get(i)[0] && list.get(i)[1] <= max) {
				continue;
			} else if(list.get(i)[0] < max) {
				sum += (list.get(i)[1] - max);
			} else {
				sum += (list.get(i)[1] - list.get(i)[0]);
			}			
			min = list.get(i)[0];
			max = list.get(i)[1];
		}
		System.out.println(sum);
	}
}