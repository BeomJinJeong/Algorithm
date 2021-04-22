package com.ssafy.code.problem.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10_원점으로집합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i] = Math.abs(Integer.parseInt(st.nextToken()));
				arr[i] += Math.abs(Integer.parseInt(st.nextToken()));
			}
			int ans = -1, lcm1 = arr[0];
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == 0) continue;
				lcm1 = lcm(lcm1, arr[i]);
			}
			int lim = lcm1 * 2;
			int start = 0;
			for(int i = 0; i <= lim; i++) {
				start += i;
				if(start == lcm1) {
					ans = i;
					break;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	private static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
	private static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}
