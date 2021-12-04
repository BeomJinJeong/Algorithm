package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q2036_수열의점수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long cnt = 0;
		ArrayList<Long> plus = new ArrayList<>();
		ArrayList<Long> minus = new ArrayList<>();
		
		
		for(int i = 0; i < N; i++) {
			long a = Long.parseLong(br.readLine());
			if(a > 0) plus.add(a);
			else if(a <= 0) minus.add(a);
		}
		
		Collections.sort(minus);
		Collections.sort(plus, Collections.reverseOrder());
		
		int size = 0;
		if(plus.size() % 2 != 0) size = plus.size() - 1;
		else size = plus.size();
		
		while(size > 0) {
			Long a = plus.get(0);
			Long b = plus.get(1);
			
			if(a == 1 | b == 1) {
				cnt += a;
				cnt += b;
			} else {				
				cnt += (a * b);
			}			
			plus.remove(1);
			plus.remove(0);
			size -= 2;
		}
		if(plus.size() > 0) cnt += plus.get(0);
		
		
		if(minus.size() % 2 != 0) size = minus.size() - 1;
		else size = minus.size();
		
		while(size > 0) {
			cnt += (minus.get(0) * minus.get(1));
			minus.remove(1);
			minus.remove(0);
			size -= 2;
		}
		if(minus.size() > 0) cnt += minus.get(0);
		System.out.println(cnt);
	}
}
