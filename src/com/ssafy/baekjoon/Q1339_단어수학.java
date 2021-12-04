package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q1339_단어수학 {
	static class t {
		String s;
		int val;
		public t(String s, int val) {
			super();
			this.s = s;
			this.val = val;
		}
	}
	static String sample = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[26];
		String[] str = new String[N];
		int value = 9;
		for(int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		for(int i = 0; i < N; i++) {
			for(int j = str[i].length(); j > 0; j--) {
				int idx = sample.indexOf(str[i].substring(j - 1, j));
				cnt[idx] += Math.pow(10, str[i].length() -j);
			}
		}
		ArrayList<t> list = new ArrayList<>();
		for(int i = 0; i < 26; i++) {
			if(cnt[i] != 0) {				
				list.add(new t(sample.substring(i, i + 1), cnt[i]));
			}
		}
		Collections.sort(list, new Comparator<t>() {
			@Override
			public int compare(t o1, t o2) {
				return o2.val - o1.val;
			}			
		});
		for(int i = 0; i < list.size(); i++) {
			list.set(i, new t(list.get(i).s, list.get(i).val * value--));
		}
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i).val;
		}
		System.out.println(sum);
	}
}
