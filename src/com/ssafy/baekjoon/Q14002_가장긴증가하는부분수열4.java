package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] D = new int[N];
		String[] str = br.readLine().split(" ");
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
			list.get(i).add(arr[i]);
		}
		int max = 0, idx = 0;
		for(int i = 0; i < N; i++) {
			D[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && D[i] < D[j] + 1) {
					list.get(i).clear();
					for(int a : list.get(j)) {
						list.get(i).add(a);
					}
					list.get(i).add(arr[i]);
					D[i] = D[j] + 1;
				}
			}
			if(max < D[i]) {
				max = D[i];
				idx = i;
			}
		}
//		Collections.sort(list.get(idx));
		System.out.println(max);
		for(int a : list.get(idx)) {
			System.out.print(a + " ");
		}
	}
}
