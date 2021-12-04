package com.ssafy.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q05_구간합 {
	static long[] num;
	static long result, start, end, mul;
	static void cal(long a) {
		for(long i = a; i > 0; i /= 10) {
			String s = Long.toString(i);
			int t = Integer.parseInt(s.substring(s.length() - 1, s.length()));
			num[t] += mul;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= test; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());
			// 초기화
			num = new long[10];
			result = 0;
			mul = 1;
			if(start==0) start=1;
			while (start <= end) {
				while(start%10!=0 && start<=end) {
					cal(start);
					start++;
				}
				if(start>end) break;
				while(end%10!=9 && start<=end) {
					cal(end);
					end--;
				}
				long diff = end/10 - start/10 +1;
				for(int i=0;i<10;i++)
					num[i]+=diff*mul;
				mul*=10;
				start/=10;
				end/=10;
			}		
			for (int i = 1; i < 10; i++)
				result += (i * num[i]);
			System.out.println("#" + t + " " + result);
		}
	}
}
