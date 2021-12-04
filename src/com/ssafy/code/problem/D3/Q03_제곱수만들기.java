package com.ssafy.code.problem.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q03_제곱수만들기 { // 시간초과 . boolean 배열을 만들어서 미리 제곱수를 판별해보자
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= T; t++) {
			StringBuilder st = new StringBuilder();
			int N = Integer.parseInt(br.readLine().trim());
			for(int i = 1; i <= N; i++) {
				double j = Math.sqrt(N * i);
				int intSqrt = (int)j;
				if(intSqrt == j) {
					st.append("#").append(t).append(" ").append(i).append("\n");
					bw.write(st.toString());
					break;
				}
			}
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
