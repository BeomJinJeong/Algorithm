package com.ssafy.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q02_조합 {
	static int N, R;
	static long[] fac = new long[1000001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		fac[0] = 1;
		
		for(int i = 1; i <= 1000000; i++) {
			fac[i] = fac[i - 1] * i % 1234567891;
		}
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			long ans = comb(N, R, 1234567891);
			System.out.println("#" + t + " " + ans);
		}
	}
	private static long comb(int n, int r, int p) {
		if(r == 0) return 1L;
		return (fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p;
	}
	private static long power(long x, long y, long p) {
		long res = 1L;
		x = x % p;
		
		while(y > 0) {
			if(y % 2 == 1)	res = (res * x) % p;
			y =  y >> 1;	
			x = (x * x) % p;
		}
		return res;
	}
}
