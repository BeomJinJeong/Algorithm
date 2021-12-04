package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q14891_톱니바퀴 {
	static boolean[] check;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			int[] temp = new int[9];
			String str = br.readLine();
			for(int j = 1; j < 9; j ++) {
				temp[j] = Character.getNumericValue(str.charAt(j - 1));
			}
			list.add(temp);
		}
		int N = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i < N; i++) {
			check = new boolean[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			getCnt(target - 1);
			check[target - 1] = true;
			turn(target - 1, dir);
		}
		getSum();
	}
	public static void getCnt(int target) {
		for(int i = target; i < 3; i++) {
			if(list.get(i)[3] != list.get(i + 1)[7]) {
				check[i + 1] = true;
			}
		}
		for(int i = target; i > 0; i--) {
			if(list.get(i)[7] != list.get(i - 1)[3]) {
				check[i - 1] = true;
			}
		}
	}
	public static void turn(int target, int dir) {
		int[] temp = new int[9];
		if(dir == 1) {
			System.arraycopy(list.get(target), 1, temp, 2, 7);
			temp[1] = list.get(target)[8];
			for(int i = 1; i < 9; i++) {
				list.get(target)[i] = temp[i];
			}
			check[target] = false;;
			if(target - 1 >= 0 && check[target-1]) {
				turn(target - 1, -1);
			}
			if(target + 1 < 4 && check[target + 1]) {
				turn(target + 1, -1);
			}
		} else if(dir == -1) {
			System.arraycopy(list.get(target), 2, temp, 1, 7);
			temp[8] = list.get(target)[1];
			for(int i = 1; i < 9; i++) {
				list.get(target)[i] = temp[i];
			}
			check[target] = false;
			if(target - 1 >= 0 && check[target-1]) {
				turn(target - 1, 1);
			}
			if(target + 1 < 4 && check[target + 1]) {
				turn(target + 1, 1);
			}			
		}
	}
	public static void getSum() {
		int sum = 0; 
		if(list.get(0)[1] == 1) sum += 1;
		if(list.get(1)[1] == 1) sum += 2;
		if(list.get(2)[1] == 1) sum += 4;
		if(list.get(3)[1] == 1) sum += 8;
		
		System.out.println(sum);
	}
}
