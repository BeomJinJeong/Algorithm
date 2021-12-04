package com.ssafy.programmers;

public class Q2_징검다리건너기 {
	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		int answer = 0;
        int cnt = 0;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < stones.length; i++) {
        	min = Math.min(min, stones[i]);
        }
        for(int i = 0; i < stones.length; i++) {
        	stones[i] -= min;
        }
        outer : while(true) {
        	cnt = 0;
        	for(int i = 0; i < stones.length; i++) {
        		stones[i] -= 1;
        		if(stones[i] <= 0) cnt++;
        		else cnt = 0;
        		
        		if(cnt >= k) break outer;
        	}
        	answer++;
        }        
        System.out.println(answer + 1 + min);
	}
}
