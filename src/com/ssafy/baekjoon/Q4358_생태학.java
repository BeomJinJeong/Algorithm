package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q4358_생태학 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<>();
		int cnt = 0;
		
		String target = br.readLine();
		while(true) {
			map.put(target, map.getOrDefault(target, 0) + 1);
			cnt++;
			target = br.readLine();
			if(target == null || target.length() == 0) 
				break;
		}
		
		Object[] arr = map.keySet().toArray();
		Arrays.sort(arr);
		
		for(Object key : arr) {
			String sKey = (String) key;
			int val = map.get(sKey);
			
			System.out.println((String)key + " " + String.format(
					"%.4f",
					(double)(val * 100.0) / cnt
			));
		}
	}
}
