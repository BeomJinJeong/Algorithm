package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q2258_정육점 {
	static int N, M; 
	static long ans;
	static List<long[]> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = Long.MAX_VALUE;
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long[] arr = new long[] {Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())};
			list.add(arr);
		}
		Collections.sort(list, new Comparator<long[]> () {
			@Override
			public int compare(long[] o1, long[] o2) {
				if(Long.compare(o1[1], o2[1]) == 0) return Long.compare(o2[0], o1[0]);
				return Long.compare(o1[1], o2[1]);
			}
		});
		boolean check = false;
		long totalPrice = 0;
		long totalWeight = 0;
		for(int i = 0; i < list.size(); i++) {
			totalWeight += list.get(i)[0];
			if(i > 0 && list.get(i - 1)[1] == list.get(i)[1]) totalPrice += list.get(i - 1)[1];
			else totalPrice = list.get(i)[1];
			
			if(totalWeight >= M) {
				check = true;
				ans = Math.min(ans, totalPrice);
			}
		}
		if(check) System.out.println(ans);
		else System.out.println(-1);
		
	}

}
