package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q16113_시그널 {
	static String t1 = "#####";
	static String t2 = "#...#";
	static String t3 = "#.###";
	static String t4 = "#.#.#";
	static String t5 = "###.#";
	static String t6 = "###..";
	static String t7 = "..#..";
	static String t8 = "#....";
	static String t9 = ".....";
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int wall = N / 5;	// 세로로 몇 줄인지
		char[] str = br.readLine().toCharArray();
		char[][] word = new char[5][wall];	// 입력 값 2차원으로 나타낸 것
		int cnt = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < wall; j++) {
				word[i][j] = str[cnt++];
			}
		}
		StringBuilder sb = null;
		ArrayList<String> list = new ArrayList<>();		// 세로로 잘라서 리스트에 삽입
		for(int j = 0; j < wall; j++) {
			sb = new StringBuilder();
			for(int i = 0; i < 5; i++) {
				sb.append(word[i][j]);
			}
			list.add(sb.toString());
		}
		
		if(list.size() == 1 && list.get(0).equals(t1)) {	// 1만 들어왔을 때
			System.out.println("1");
			return;
		}
		
		ArrayList<String> turn = new ArrayList<>();		// 숫자 검증할 리스트
		turn.add(list.get(0));
		turn.add(list.get(1));
		
		if(turn.get(0).equals(t1) && turn.get(1).equals(t9)) System.out.print("1");
		
		for(int i = 2; i < list.size(); i++) {	
			turn.add(list.get(i));
			check(turn);
			turn.remove(0);
		}
		
		if(turn.get(0).equals(t9) && turn.get(1).equals(t1)) System.out.print("1");
		
	}
	private static void check(ArrayList<String> sam) {
		if(sam.get(0).equals(t1) && sam.get(1).equals(t2) && sam.get(2).equals(t1)) {
			System.out.print("0");
		} else if(sam.get(0).equals(t9) && sam.get(1).equals(t1) && sam.get(2).equals(t9)) {
			System.out.print("1");
		} else if(sam.get(0).equals(t3) && sam.get(1).equals(t4) && sam.get(2).equals(t5)) {
			System.out.print("2");
		} else if(sam.get(0).equals(t4) && sam.get(1).equals(t4) && sam.get(2).equals(t1)) {
			System.out.print("3");
		} else if(sam.get(0).equals(t6) && sam.get(1).equals(t7) && sam.get(2).equals(t1)) {
			System.out.print("4");
		} else if(sam.get(0).equals(t5) && sam.get(1).equals(t4) && sam.get(2).equals(t3)) {
			System.out.print("5");
		} else if(sam.get(0).equals(t1) && sam.get(1).equals(t4) && sam.get(2).equals(t3)) {
			System.out.print("6");
		} else if(sam.get(0).equals(t8) && sam.get(1).equals(t8) && sam.get(2).equals(t1)) {
			System.out.print("7");
		} else if(sam.get(0).equals(t1) && sam.get(1).equals(t4) && sam.get(2).equals(t1)) {
			System.out.print("8");
		} else if(sam.get(0).equals(t5) && sam.get(1).equals(t4) && sam.get(2).equals(t1)) {
			System.out.print("9");
		}
	}
}
