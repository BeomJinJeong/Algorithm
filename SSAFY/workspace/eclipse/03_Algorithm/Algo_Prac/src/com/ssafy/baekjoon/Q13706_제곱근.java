package com.ssafy.baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Q13706_제곱근 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sqrt(str);
		sc.close();
	}
	static void sqrt(String num) {

        BigInteger one = BigInteger.ONE;
        BigInteger two = new BigInteger("2");

        BigInteger target = new BigInteger(num);

        BigInteger left = BigInteger.ONE;
        BigInteger right = new BigInteger(num);

        BigInteger mid, x;

        while (left.compareTo(right) <= 0) {
            mid = (left.add(right)).divide(two);
            x = mid.multiply(mid);

            int ret = x.compareTo(target);
            if (ret == 0) {
                System.out.println(mid.toString());
                break;
            } else if (ret == -1) {
                left = mid.add(one);
            } else if (ret == 1) {
                right = mid.subtract(one);
            }
        }
    }
}
