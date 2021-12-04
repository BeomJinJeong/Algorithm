package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2635_수이어가기 {		// 왜 안되는지 모르겠음.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int size = 0;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			list.removeAll(list);
			list.add(N);
			list.add(i);
			int idx = 2;
			while(true) {
				int res = list.get(idx - 2) - list.get(idx - 1);
				if(res >= 0) {
					list.add(res);
					idx++;
				}
				else break;
			}
			if(size < list.size()) {
				sb = new StringBuilder();
				size = list.size();
				sb.append(list.get(0));
				for(int j = 1; j < size; j++) {
					sb.append(" ").append(list.get(j));
				}
			}
		}
		System.out.println(size);
		System.out.print(sb);
	}
}
