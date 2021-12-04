package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10972_다음순열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        nextPermutation(arr);
    }
    private static void nextPermutation(int[] arr) {
        int n = arr.length;
        boolean b = true;
        Loop1: for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                for (int j = n - 1; j >= i; j--) {
                    if (arr[j] > arr[i - 1]) {
                        int temp = arr[j];
                        arr[j] = arr[i - 1];
                        arr[i - 1] = temp;
                        int k = n - 1;
                        while (i < k) {
                            int temp2 = arr[i];
                            arr[i] = arr[k];
                            arr[k] = temp2;
                            i++;
                            k--;
                        }
                        b = false;
                        break Loop1;
                    }
                }
            }
        }
        if (b) {
            System.out.println(-1);
        } else {
        	for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
        }
    }
}
