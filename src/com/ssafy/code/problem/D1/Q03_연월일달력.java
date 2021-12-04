package com.ssafy.code.problem.D1;
import java.util.Scanner;
public class Q03_연월일달력 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int time = sc.nextInt();
			int day = time % 100;
			int month = (time % 10000) / 100;
			int year = time / 10000;
			
			if(month > 12 || month < 1) {
				System.out.print("#" + test_case + " -1");
			} else if(month==2 && day>28){
				System.out.print("#" + test_case + " -1");
			} else if(getMonth(month) && (day > 31 || day <= 0)) {
				System.out.print("#" + test_case + " -1");
			} else if(!getMonth(month) && (day > 30 || day <= 0)) {
				System.out.print("#" + test_case + " -1");
			} else {
				char[] cal = ("" + time).toCharArray();
				if(year < 1000) {
					char[] cal2 = new char[10];
					for(int i=0; i<7; i++) {
						cal2[i+1] = cal[i];
					}
					cal2[0] = '0';
					
					System.out.print("#" + test_case + " ");
					for(int i=0; i<8; i++) {
						if(i==4 || i==6) {
							System.out.print("/");
						}
						System.out.print(cal2[i]);
					}
				} else {
					System.out.print("#" + test_case + " ");
					for(int i=0; i<8; i++) {
						if(i==4 || i==6) {
							System.out.print("/");
						}
						System.out.print(cal[i]);
					}
				}
			}
			System.out.println("");
		}
		sc.close();
	}
	static boolean getMonth(int n) {
		switch(n) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return true;
		case 4:
		case 6:
		case 9:
		case 11:
			return false;
		default:
			return true;
		}
	}
}
