package com.ssafy.code.problem.D1;

public class Q06_피라미드 {
	public static void main(String[] args) {
		int blank = 0;
		int num = 0;
		int count = 3;
		while(num<=16) {
			for(int i=0; i<4-blank; i++) {
				System.out.printf("%3s", "");			
			}
			for(int i=0; i< 7 - 2*count; i++) {
				System.out.printf("%3d", num);
				num++;
			}
			System.out.println("");
			blank++;
			count--;
		}
	}
} // 배열 가지고 노는 것은 공백문자 따로, 출력 숫자 따로 가지고 놀아보자!
