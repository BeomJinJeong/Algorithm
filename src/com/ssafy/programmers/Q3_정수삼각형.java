package com.ssafy.programmers;

public class Q3_정수삼각형 {
	public static void main(String[] args) {
		int[][] triangle = {
				{7, 0, 0, 0, 0},
				{3, 8, 0, 0, 0},
				{8, 1, 0, 0, 0},
				{2, 7, 4, 4, 0},
				{4, 5, 2, 6, 5}
		};		
		int answer = 0;
		
		int size = triangle[triangle.length - 1].length;
		int[][] dp = new int[triangle.length][size];
		dp[0][0] = triangle[0][0];
		for(int i = 1; i < triangle.length; i++) {
			for(int j = 0; j < i + 1; j++) {
				if(j == 0) {
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				} else if(j == i) {
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				} else {
					int a = dp[i - 1][j - 1] + triangle[i][j];
					int b = dp[i - 1][j] + triangle[i][j];
					
					dp[i][j] = Math.max(a, b);
				}
			}
		}
		for(int i = 0; i < size; i++) {
			answer = Math.max(answer, dp[triangle.length - 1][i]);
		}
		System.out.println(answer);
//		return answer;
	}
}
