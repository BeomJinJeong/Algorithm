package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Paper {
	int row;
	int col;
	int rSize;
	int cSize;
	public Paper(int row, int col, int rSize, int cSize) {
		super();
		this.row = row;
		this.col = col;
		this.rSize = rSize;
		this.cSize = cSize;
	}
}
public class Q2628_종이자르기 {
	static ArrayList<Paper> p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		p = new ArrayList<>();
		p.add(new Paper(0, 0, H, W));
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a == 0) goH(b);
			else if(a == 1) goW(b);
		}
		getW();
	}
	public static void getW() {
		int max = 0;
		for(int i = 0; i < p.size(); i++) {
			Paper target = p.get(i);
			int w = target.rSize * target.cSize;
			max = Math.max(max, w);
		}
		System.out.println(max);
	}
	public static void goH(int cut) {
		int size = p.size();
		for(int i = 0; i < size; i++) {
			Paper target = p.get(i);
			if(target.row < cut && target.row + target.rSize > cut) {
				Paper div1 = new Paper(target.row, target.col, cut - target.row, target.cSize);
				Paper div2 = new Paper(cut, target.col, target.row + target.rSize - cut, target.cSize);
				p.remove(target);
				p.add(div1); p.add(div2);
				i--;
			}
		}
	}
	public static void goW(int cut) {
		int size = p.size();
		for(int i = 0; i < size; i++) {
			Paper target = p.get(i);
			if(target.col < cut && target.col+ target.cSize > cut) {
				Paper div1 = new Paper(target.row, target.col, target.rSize, cut - target.col);
				Paper div2 = new Paper(target.row, cut, target.rSize, target.col + target.cSize - cut);
				p.remove(target);
				p.add(div1); p.add(div2);
				i--;
			}
		}
	}
}
