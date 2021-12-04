package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10157_자리배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(br.readLine());
		
		if(cnt > r * c) {
			System.out.println("0");
			return;
		}
		if(cnt == 1) {
			System.out.println("1 1");
			return;
		}
		int start = 1;
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			start += ((r - 2*i) + (c - 2*i) - 2)*2;
			if(start > cnt) {
				start -= ((r - 2*i) + (c - 2*i) - 2)*2;
				int r1 = r - 2*(i);
				int c1 = c - 2*(i);
				r = i + 1;
				c = i + 1;
				if(cnt == start) {
					break;
				}
				if(cnt <= (start + r1 - 1)) {
					r += cnt - start;
					break;
				} else {
					start += r1 - 1;
					r += r1 - 1;
				}
				if(cnt <= (start + c1 - 1)) {
					c += cnt - start;
					break;
				} else {
					start += c1 - 1;
					c += c1 - 1;
				}
				if(cnt <= (start + r1 - 1)) {
					r -= cnt - start;
					break;
				} else {
					start += r1 - 1;
					r -= r1 - 1;
				}
				if(cnt < (start + c1 - 1)) {
					c -= cnt - start;
					break;
				}
			}
		}
		System.out.println(c + " " + r);
	}
}
