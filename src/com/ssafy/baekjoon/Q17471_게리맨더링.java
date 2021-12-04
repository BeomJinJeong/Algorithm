package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17471_게리맨더링 {
	static int N, ans = Integer.MAX_VALUE;
	static int[] man;
	static ArrayList<Integer>[] list;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		man = new int[N + 1];
		int[] team = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			man[i] = Integer.parseInt(st.nextToken());
		}
		list = new ArrayList[N + 1];
		for(int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		sub(team, 1);
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	private static void sub(int[] team, int cnt) {
		if(cnt == N + 1) {
			if(checkTeam(team, 0) && checkTeam(team, 1)) {
				ans = Math.min(ans, diff(team));
			}
		} else {			
			team[cnt] = 1;
			sub(team, cnt + 1);
			team[cnt] = 0;
			sub(team, cnt + 1);
		}
	}
	private static boolean checkTeam(int[] team, int idx) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(team[i] == idx) {
				q.add(i);
				visited[i] = true;
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i = 0; i < list[cur].size(); i++) {
				int tar = list[cur].get(i);
				if(visited[tar]) continue;
				if(team[tar] != idx) continue;
				q.add(tar);
				visited[tar] = true;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(team[i] != idx) continue;
			if(!visited[i]) return false;
		}
		return true;
	}
	private static int diff(int[] team) {
		int sum1 = 0, sum2 = 0;
		for(int i = 1; i <= N; i++) {
			if(team[i] == 0) sum1 += man[i];
			else sum2 += man[i];
		}
		return Math.abs(sum1 - sum2);
	}
}
