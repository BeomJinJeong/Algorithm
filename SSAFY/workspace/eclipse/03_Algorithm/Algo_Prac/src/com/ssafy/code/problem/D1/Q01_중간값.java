package com.ssafy.code.problem.D1;
import java.util.Scanner;

public class Q01_중간값 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        int[] arr = new int[2];
		for(int test_case = 1; test_case <= T; test_case++)
		{
			for(int i = 0; i < arr.length; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println("#" + test_case + " " + comb(arr[0], arr[1]));
            for(int i = 0; i < arr.length; i++){
                arr[i] = 0;
            }
		}
		sc.close();
	}
	static String comb(int a, int b){
        if(a>b){ return ">"; }
        else if(a<b){ return "<"; }
        else { return "="; }
    }

}
