package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q5430_AC {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			String[] commands = br.readLine().split("");
			int N = Integer.parseInt(br.readLine());
			Deque<String> dq = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), ",");
			for(int i = 0; i < N; i++) {
				dq.add(st.nextToken().replace("[", "").replace("]", ""));
			}
			
			
			try {
				boolean front = true;
				int rCnt = 0;
				for(int i = 0; i < commands.length; i++) {
					if(commands[i].equals("R")) {
						if(front) front = false;
						else front = true;
						rCnt++;
					} else {
						if(dq.size() == 0) throw new Exception();
						if(front) dq.pollFirst();
						else dq.pollLast();
					}
				}
				
				int size = dq.size();
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				
				if(rCnt % 2 == 1) {
					for(int i = 0; i < size; i++) {
						if(i == size - 1) sb.append(dq.pollLast());
						else sb.append(dq.pollLast()).append(",");
					}
				} else {
					for(int i = 0; i < size; i++) {
						if(i == size - 1) sb.append(dq.pollFirst());
						else sb.append(dq.pollFirst()).append(",");
					}
				}
				sb.append("]");
				System.out.println(sb.toString());
			} catch (Exception e) {
				System.out.println("error");
			}
		}
	}
}
