package com.ssafy.code.problem.D1;
import java.util.Scanner;

public class Q04_알파벳숫자변환 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String alpa = sc.next();
		for(int i=0; i<alpa.length(); i++) {
			System.out.printf("%d ", getNum(alpa.substring(i, i+1)));
		}
		sc.close();
	}
	static int getNum(String str) {
		switch(str) {
		case "A":
			return 1;
		case "B":
			return 2;
		case "C":
			return 3;
		case "D":
			return 4;
		case "E":
			return 5;
		case "F":
			return 6;
		case "G":
			return 7;
		case "H":
			return 8;
		case "I":
			return 9;
		case "J":
			return 10;
		case "K":
			return 11;
		case "L":
			return 12;
		case "M":
			return 13;
		case "N":
			return 14;
		case "O":
			return 15;
		case "P":
			return 16;
		case "Q":
			return 17;
		case "R":
			return 18;
		case "S":
			return 19;
		case "T":
			return 20;
		case "U":
			return 21;
		case "V":
			return 22;
		case "W":
			return 23;
		case "X":
			return 24;
		case "Y":
			return 25;
		case "Z":
			return 26;
		default:
			return 0;
		}
	}
}
