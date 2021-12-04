package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q13022_늑대와올바른단어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		
		int[] cnt = new int[4];
		
		Queue<String> q = new LinkedList<>();
		for(int i = 0; i < word.length(); i++) {
			q.add(word.substring(i, i + 1));
		}
		String pre = q.poll();
		if(!pre.equals("w")) {
			System.out.println(0);
			return;
		}
		cnt[0]++;
		boolean flag = true;
		
		while(!q.isEmpty()) {
			String cur = q.poll();
			
			if(cur.equals(pre)) {
				switch(cur) {
				case "w":
					cnt[0]++;
					break;
				case "o":
					cnt[1]++;
					break;
				case "l":
					cnt[2]++;
					break;
				case "f":
					cnt[3]++;
					break;
				}
			} else {
				switch(cur) {
				case "w":
					if(!pre.equals("f")) flag = false;
					else {
						for(int i = 1; i < 4; i++) {
							if(cnt[i - 1] != cnt[i]){
								flag = false;
								break;
							}
						}
						cnt[0]++;
					}
					break;
				case "o":
					if(!pre.equals("w")) flag = false;
					else cnt[1]++;
					break;
				case "l":
					if(!pre.equals("o")) flag = false;
					else cnt[2]++;
					break;
				case "f":
					if(!pre.equals("l")) flag = false;
					else cnt[3]++;
					break;
				}
			}
			if(!flag) {
				System.out.println(0);
				return;
			}
			pre = cur;
		}
		for(int i = 1; i < 4; i++) {
			if(cnt[i - 1] != cnt[i]) {
				System.out.println(0);
				return;
			}			
		}
		System.out.println(1);
	}
}
