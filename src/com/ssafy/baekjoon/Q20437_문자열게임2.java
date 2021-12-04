package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q20437_문자열게임2 {
	static class index {
		char c;
		int idx;
		public index(char c, int idx) {
			super();
			this.c = c;
			this.idx = idx;
		}		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String str = br.readLine();
			int N = Integer.parseInt(br.readLine());
			ArrayList<index> list = new ArrayList<>();
			int min = Integer.MAX_VALUE, max = 0;
			for(int i = 0; i < str.length(); i++) {
				list.add(new index(str.charAt(i), i));
			}
			Collections.sort(list, new Comparator<index>() {
				@Override
				public int compare(index o1, index o2) {
					int diff = o1.c - o2.c;					
					return (diff == 0 ? o1.idx - o2.idx : diff);
				}				
			});
			boolean flag = false;
			for(int i = 0; i < list.size() - N + 1; i++) {
				if(list.get(i).c == list.get(i + N - 1).c) {
					flag = true;
					min = Math.min(min, list.get(i + N - 1).idx - list.get(i).idx + 1);
					max = Math.max(max, list.get(i + N - 1).idx - list.get(i).idx + 1);
				}
			}
			if(flag) System.out.println(min + " " + max);
			else System.out.println(-1);
		}
	}
}
