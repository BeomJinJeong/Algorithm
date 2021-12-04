package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1976_여행가자 {
	static int N, M;
	static int[] repres; 	// 대표자
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());	// 도시 수
		M = Integer.parseInt(br.readLine());	// 여행 계획에 속한 도시 수
		
		// 대표자 배열 구성하기
		makeSet();
		
		// 그래프 정보 읽어보기
		StringTokenizer st = null;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				// 값이 1이면 연결된 노드 ==> 연결하자
				if(st.nextToken().equals("1")) {
					union(i, j);
				}
			}
		}
		// 연결 가능한 지점들은 모두 연결된 상태		
		// 여행하려는 도시들의 정보 확인
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		from = find(from);
		
		while(st.hasMoreTokens()) {
			int to = Integer.parseInt(st.nextToken());
			if(from != find(to)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	private static void makeSet() {
		// 각자가 대표자로 구성한다.
		repres = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			repres[i] = i;
		}
	}
	private static int find(int a) {
		if(repres[a] == a) return a;
		// path compression
		return repres[a] = find(repres[a]);
	}
	private static boolean union(int a, int b) {
		if(find(a) == find(b)) return false;
		repres[a] = b;
		return true;
	}
}
