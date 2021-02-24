package com.ssafy.code.problem.D1;
import java.util.Arrays;
import java.util.Scanner;

public class Q05_입력받은값의갯수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String[] buf = str.split(" ");
		int count = 0;
		int[] buf2 = new int[buf.length];
		
		for(int i=0; i<buf.length; i++) {
			count++;
			buf2[i] = Integer.parseInt(buf[i]);
		}
		System.out.println(Arrays.toString(buf2));
		System.out.println(count);
		sc.close();
	}
}
