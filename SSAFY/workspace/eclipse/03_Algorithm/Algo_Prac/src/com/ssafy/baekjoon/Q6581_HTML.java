package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6581_HTML {	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String input = "";
		int cnt = 0;
		while((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			int size = st.countTokens();
			for(int i = 0; i < size; i++) {
				String str = st.nextToken();
				
				if(str.equals("<br>")) {
					sb.append("\n");
					cnt = 0;
				}
				else if(str.equals("<hr>")) {
					if(cnt != 0) {
						sb.append("\n");
						cnt = 0;
					}
					for(int j = 0; j < 80; j++) {
						sb.append("-");
					}
					sb.append("\n");
				} 
				else if(str.equals("")) {}
				else {
					if(cnt + str.length() > 80) {
						sb.append("\n");
						cnt = 0;
					} else cnt += str.length();
					
					sb.append(str);	
					
					if(cnt < 80) {
						sb.append(" ");
						cnt++;
					}
				}
			}
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}
}