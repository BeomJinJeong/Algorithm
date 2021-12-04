package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10158_개미2 {
	static int W, H, t;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
		
		int pt = t % (W * 2);
		int qt = t % (H * 2);
		
		p = p + pt;
		if(p > 2*W) p -= 2*W;
		else if(p > W) p = W - (p - W);
		q = q + qt;
		if(q > 2*H) q = q - 2*H;
		else if(q > H) q = H - (q - H);
		System.out.println(p + " " + q);
	}
}
