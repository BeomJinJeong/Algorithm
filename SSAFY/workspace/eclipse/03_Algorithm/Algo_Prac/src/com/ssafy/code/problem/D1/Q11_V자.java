package com.ssafy.code.problem.D1;

public class Q11_V자 {
	public static void main(String[] args) {
		int blank1 = 5; 
		int count = 1;
		int target = 10 / 2;
		boolean increase = true;
		
		for(int i = 0; i < 9; i++) {
			if(i == target) increase = false;
			if(increase) {
				for(int j = blank1; j > 1; j--) {
					System.out.print('\t');
				}
				System.out.print(count++);
				blank1--;
				if(i >= 1) {
					for(int k = 2 * blank1; k <= 7; k++) {
						System.out.print("\t");
					}
					System.out.println(count++);
				}
				System.out.println("");
			} else {
				for(int j = blank1; j < 2 * blank1 + 1; j++) {
					System.out.print('\t');
				}
				System.out.print(count++);
				if(count > 16) return;
				blank1++;
				if(i >= 1) {
					for(int k = 2 * blank1; k <= 7; k++) {
						System.out.print("\t");
					}
					System.out.println(count++);
				}
				System.out.println("");
			}
		}
	}
}
