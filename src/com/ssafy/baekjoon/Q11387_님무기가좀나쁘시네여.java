package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11387_님무기가좀나쁘시네여 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		long[][] arr = new long[4][5];
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		double nowCri = arr[0][0] 
				* (1 + ((double)arr[0][1]/100))
				* (
						(1 - Math.min(((double)arr[0][2]/100), 1))
						+ Math.min(((double)arr[0][2]/100), 1)
						* ((double)arr[0][3]/100)
						)
				* (1 + ((double)arr[0][4]/100));
		
		double nowPabu = arr[1][0] 
				* (1 + ((double)arr[1][1]/100))
				* (
						(1 - Math.min(((double)arr[1][2]/100), 1))
						+ Math.min(((double)arr[1][2]/100), 1)
						* ((double)arr[1][3]/100)
						)
				* (1 + ((double)arr[1][4]/100));
		
		
		for(int i = 0; i < 5; i++) {
			arr[0][i] = arr[0][i] - arr[2][i] + arr[3][i];
			arr[1][i] = arr[1][i] - arr[3][i] + arr[2][i];
		}
		
		double changeCri = arr[0][0] 
				* (1 + ((double)arr[0][1]/100))
				* (
						(1 - Math.min(((double)arr[0][2]/100), 1))
						+ Math.min(((double)arr[0][2]/100), 1)
						* ((double)arr[0][3]/100)
						)
				* (1 + ((double)arr[0][4]/100));
		
		double changePabu = arr[1][0] 
				* (1 + ((double)arr[1][1]/100))
				* (
						(1 - Math.min(((double)arr[1][2]/100), 1))
						+ Math.min(((double)arr[1][2]/100), 1)
						* ((double)arr[1][3]/100)
						)
				* (1 + ((double)arr[1][4]/100));
		
		if(nowCri > changeCri) System.out.println("-");
		else if(nowCri < changeCri) System.out.println("+");
		else System.out.println(0);
		if(nowPabu > changePabu) System.out.println("-");
		else if(nowPabu < changePabu) System.out.println("+");
		else System.out.println(0);
	}
}
