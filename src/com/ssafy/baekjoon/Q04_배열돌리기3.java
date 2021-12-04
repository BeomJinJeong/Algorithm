package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q04_배열돌리기3 {
	static int[][] arr;
	static int N, M, R;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			switch(Integer.parseInt(st.nextToken())) {
			case 1:
				func1();
				break;
			case 2:
				func2();
				break;
			case 3:
				func3();
				break;
			case 4:
				func3();
				func3();
				func3();
				break;
			case 5:
				func5();
				break;
			case 6:
				func6();
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i][0]);
			for(int j = 1; j < arr[i].length; j++) {
				sb.append(" ").append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void func1() {
		for(int i = 0; i < N / 2; i++) {
			int[] temp = new int[M];
			temp = arr[N-i-1];
			arr[N-1-i] = arr[i];
			arr[i] = temp;
		}
	}
	public static void func2() {
		for(int i = 0; i < N; i++) {
			int[] temp = new int[M];
			for(int j = 0; j < M /2; j++) {
				temp[j] = arr[i][j];
				arr[i][j] = arr[i][M-j-1];
				arr[i][M-j-1] = temp[j];
			}
		}
	}
	public static void func3() {
		int pos = 0;
		int[][] temp = new int[M][N];
		
		for(int j = 0; j < M; j++) {
			for(int i = N-1; i >= 0; i--) {
				temp[j][pos++] = arr[i][j];
			}
			pos = 0;
		}
		arr = temp;
		int temp1 = 0;
		temp1 = M;
		M = N;
		N = temp1;
	}
	public static void func5() {
		int[][] temp = new int[N/2][M/2];
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				temp[i][j] = arr[i][j];
				arr[i][j] = arr[i + N/2][j];
			}
		}
		for(int i = N/2; i < N; i++) {
			for(int j = 0; j < M/2; j++) {
				arr[i][j] = arr[i][j + M/2];
			}
		}
		for(int i = N/2; i < N; i++) {
			for(int j = M/2; j < M; j++) {
				arr[i][j] = arr[i - N/2][j];
			}
		}
		for(int i = 0; i < N/2; i++) {
			for(int j = M/2; j < M; j++) {
				arr[i][j] = temp[i][j - M/2];				
			}
		}
	}
	public static void func6() {
		int[][] temp = new int[N/2][M/2];
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				temp[i][j] = arr[i][j];
				arr[i][j] = arr[i][j + M/2];
			}
		}
		for(int i = 0; i < N/2; i++) {
			for(int j = M/2; j < M; j++) {
				arr[i][j] = arr[i + N/2][j];				
			}
		}
		for(int i = N/2; i < N; i++) {
			for(int j = M/2; j < M; j++) {
				arr[i][j] = arr[i][j - M/2];
			}
		}
		for(int i = N/2; i < N; i++) {
			for(int j = 0; j < M/2; j++) {
				arr[i][j] = temp[i - N/2][j];
			}
		}
	}
}
