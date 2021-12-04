package com.ssafy.code.problem.D1;
import java.util.Scanner;

public class Q07_알파벳숫자변환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] arr = new int[str.length()];
		String[] ch1 = new String[str.length()];
		
		for(int i = 0; i < arr.length; i++) {
			ch1 = str.split("");
			arr[i] = ch1[i].charAt(0);
			System.out.printf("%d ", arr[i]%64);
		}
		sc.close();
	}
}
