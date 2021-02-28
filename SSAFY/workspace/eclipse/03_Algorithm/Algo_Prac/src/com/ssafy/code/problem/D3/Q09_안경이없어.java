package com.ssafy.code.problem.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q09_안경이없어 {
	static String noH = "CEFGHIJKLMNSTUVWXYZ";
	static String oneH = "ADOPQR";
	static String twoH = "B";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] str1 = st.nextToken().split("");
			String[] str2 = st.nextToken().split("");
			
			if(str1.length != str2.length) {
				System.out.println("#" + t + " " + "DIFF");
				continue;
			}
			
			boolean same = true;
			
			int sum1 = 0, sum2 = 0;
			for(int i = 0; i < str1.length; i++) {
				
				if(twoH.contains(str1[i])) sum1 = 3;
				else if(oneH.contains(str1[i])) sum1 = 2;
				else if(noH.contains(str1[i])) sum1 = 1;
				
				if(twoH.contains(str2[i])) sum2 = 3;
				else if(oneH.contains(str2[i])) sum2 = 2;
				else if(noH.contains(str2[i])) sum2 = 1;
				
				if(sum1 != sum2) {
					same = false;
					break;
				}
				
			}
			System.out.print("#" + t + " ");
			System.out.println(same ? "SAME" : "DIFF");
		}
	}
}
