package com.ssafy.code.problem.D2;

import java.util.Scanner;

public class Q06_회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String str = sc.nextLine();
            int mid = str.length()/2;
            String[] buf = str.split("");
            boolean check = false;
            String[] temp = new String[mid];
             
            if(str.length()%2==1) {
                for(int i = str.length()-1; i > mid; i--) {
                    temp[str.length()-1 - i] = buf[i];
                }
            } else {
                for(int i = str.length()-1; i >= mid; i--) {
                    temp[str.length()-1 - i] = buf[i];
                }
            }
             
            for(int i = 0; i < mid; i++) {
                if(buf[i].equals(temp[i])) check = true; 
                else {
                    check = false;
                    break;
                }
            }
            if(check) System.out.println("#" + test_case + " " + "1");
            else System.out.println("#" + test_case + " " + "0");
		}
		sc.close();
	}
}
