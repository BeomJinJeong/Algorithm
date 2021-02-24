package com.ssafy.code.problem.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q06_신뢰 { // 추가 필요
	static boolean[] blue, orange;
	static int b = 1, o = 1, remain;
	static int count = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			blue = new boolean[101];
			orange = new boolean[101];
			for(int i = 0; i < N; i++) {
				String target = st.nextToken();
				String num = st.nextToken();
				if(target.equals("B")) {
					blue[Integer.parseInt(num)] = true;
					remain++;
				}
				else if(target.equals("O")) {
					orange[Integer.parseInt(num)] = true;
					remain++;
				}
			}
			
			move(0, 0);
			System.out.println(count);
			b = 1; o = 1; count = 0; remain = 0;
		}
	}
	static void move(int bStatus, int oStatus) {
		count++;
		if(remain <= 0) return;
		if(b >= 100) b = 100;
		if(o >= 100) o = 100;
		
		if(blue[b]) bStatus = 1;
		if(orange[o]) oStatus = 1;
		if(bStatus == 1 && oStatus == 1) bStatus = 2;
		
		if(bStatus == 1) {
			blue[b] = false;
			bStatus = 0;
			remain--;
		} else if(bStatus == 0) {
			b++;
		}
		if(oStatus == 1) {
			orange[o] = false;
			oStatus = 0;
			remain--;
		} else if(oStatus == 0) {
			o++;
		}
		move(bStatus, oStatus);
	}
}
