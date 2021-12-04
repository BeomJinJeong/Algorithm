package com.ssafy.baekjoon;

import java.util.*;
import java.io.*;
public class Q2412_암벽등반 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] {0, 0});
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new int[] {x, y});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int diff = o1[0] - o2[0];
				return diff==0 ? o1[1] - o2[1] : diff;
			}
		});
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		boolean[] check = new boolean[N + 1];
		check[0] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int cur = q.poll();
				
				if(list.get(cur)[1] == T) {
					System.out.println(cnt);
					System.exit(0);
				}
				
				for(int j = cur + 1; j < list.size() && Math.abs(list.get(j)[0] - list.get(cur)[0]) <= 2; j++) {
					if(!check[j] && Math.abs(list.get(cur)[1] - list.get(j)[1]) <= 2) {
						q.add(j);
						check[j] = true;
					}
				}
				for(int j = cur - 1; j >= 0 && Math.abs(list.get(j)[0] - list.get(cur)[0]) <= 2; j--) {
					if(!check[j] && Math.abs(list.get(cur)[1] - list.get(j)[1]) <= 2) {
						q.add(j);
						check[j] = true;
					}
				}
			}
			cnt++;
		}
		System.out.println(-1);
	}
}
