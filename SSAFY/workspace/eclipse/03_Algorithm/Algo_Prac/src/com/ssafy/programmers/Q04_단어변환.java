package com.ssafy.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Q04_단어변환 {
	public static void main(String[] args) throws Exception {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		
		boolean[] check = new boolean[words.length];
		Queue<String> q = new LinkedList<>();
		q.add(begin);
		
		int cnt = 0;
		int answer = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {				
				String cur = q.poll();
				
				if(cur.equals(target)) {
					answer = cnt;
					break;
				}
				
				for(int j = 0; j < words.length; j++) {
					int c = 0;
					for(int k = 0; k < words[j].length(); k++) {
						if(!cur.substring(k, k + 1).equals(words[j].substring(k, k + 1))) c++;
					}
					if(c == 1 && !check[j]) {
						q.add(words[j]);
						check[j] = true;
					}
				}
			}
			cnt++;
		}
		System.out.println(answer);
	}
}
