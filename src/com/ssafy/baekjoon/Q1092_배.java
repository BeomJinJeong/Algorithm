package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q1092_배 {
	static int N, M;
	static List<Integer> crain, box;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		crain = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			crain.add(Integer.parseInt(st.nextToken()));
		}
		M = Integer.parseInt(br.readLine());
		box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(crain, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		
		if(box.get(0) > crain.get(0)) System.out.println(-1);
		else {
			int time = 0;
			while(!box.isEmpty()) {
				int idx = 0;
				for(int i = 0; i < crain.size();) {
					if(idx == box.size()) break;
					else if(crain.get(i) >= box.get(idx)) {
						box.remove(idx);
						i++;
					} else idx++;
				}
				time++;
			}
			System.out.println(time);
		}
	}
}
