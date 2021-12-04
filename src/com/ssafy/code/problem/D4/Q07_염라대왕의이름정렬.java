package com.ssafy.code.problem.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q07_염라대왕의이름정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			ArrayList<String> list = new ArrayList<>();
			list.clear();
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				list.add(str);
			}
			Collections.sort(list, new Comparator<String>() {
				public int compare(String o1, String o2) {
					int diff = o1.length() - o2.length();
					return diff == 0 ? o1.compareTo(o2) : diff;
				}
			});
			System.out.println("#" + t);
			String tmp = null;
			for(String a : list) {
				if(!a.equals(tmp)) {					
					System.out.println(a);
				}
				tmp = a;
			}
		}
	}
}
