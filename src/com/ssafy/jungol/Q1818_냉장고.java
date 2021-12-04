package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1818_냉장고 {
	static class Ref implements Comparable<Ref>{
		int minus;
		int plus;
		
		public Ref(int minus, int plus) {
			super();
			this.minus = minus;
			this.plus = plus;
		}

		@Override
		public int compareTo(Ref o) {
			 int diff = this.plus - o.plus;
			return diff;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Ref[] refs = new Ref[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			refs[i] = new Ref(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		getRef(refs);
	}
	public static void getRef(Ref[] r) {
		int count = 1;
		Arrays.sort(r);
		Ref ref = r[0];
		int i = 1; 
		while( i < r.length ) {
			if(r[i].minus > ref.plus) {
				ref = r[i];
				count++;
			}
			i++;
		}
		System.out.println(count);
	}
}	
