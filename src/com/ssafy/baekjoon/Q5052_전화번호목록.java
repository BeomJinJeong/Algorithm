package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q5052_전화번호목록 { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		outer : for(int t = 0;  t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			for(int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}
			Arrays.sort(arr, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			for(int i = 1; i < N; i++) {
				if(arr[i].startsWith(arr[i-1])) {
					System.out.println("NO");
					continue outer;
				}
			}
			System.out.println("YES");
		}
	}
}
