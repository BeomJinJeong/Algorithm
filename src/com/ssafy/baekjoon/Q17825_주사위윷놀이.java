package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q17825_주사위윷놀이 {
	static class Node {
		int value;
		int flag;
		Node nextNode;
		public Node(int value, int flag) {
			super();
			this.value = value;
			this.flag = flag;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] command = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Node> map = new ArrayList<>();
		for(int i = 0; i <= 20; i++) {
			map.add(makeNode(i * 2, 1));
			if(i > 0) map.get(i - 1).nextNode = map.get(i);
		}
		for(int i = 1; i <= 3; i++) {
			map.add(makeNode(10 + (i * 2), 1));
			if(i > 1) map.get(19 + i).nextNode = map.get(20 + i);
		}
		for(int i = 1; i <= 2; i++) {
			map.add(makeNode(20 + (i * 2), 1));
			if(i > 1) map.get(22 + i).nextNode = map.get(23 + i);
		}
		
	}
	public static Node makeNode(int val, int flag) {
		Node newNode = new Node(val, flag);
		return newNode;
	}
}
