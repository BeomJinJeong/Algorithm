package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Memory {
	int value;
	int pos;
	public Memory(int value, int pos) {
		this.value = value;
		this.pos = pos + 1;
	}
	public String toString() {
		return this.value + " ";
	}
}
public class Q02_탑02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Memory> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		Memory[] mb = new Memory[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			mb[i] = new Memory(Integer.parseInt(st.nextToken()), i);
		}
		for(int i = n-1; i >= 0; i--) { // 스택값보다 큰 값이 들어오면 스택값을 빼고 value를 입력값의 pos로 교체
			if(stack.isEmpty() || mb[i].value < stack.peek().value){
				stack.push(mb[i]);
				continue;
			} 
			stack.pop().value = mb[i].pos;
			if(!stack.isEmpty() && stack.peek().value <= mb[i].value) {
				i++;
				continue;
			}
			stack.push(mb[i]);
		}
		int size = stack.size();
		for(int i = 0; i < size; i++) {
			stack.pop().value = 0;
		}
		for(Memory m : mb) {
			System.out.print(m);
		}
	}
}
