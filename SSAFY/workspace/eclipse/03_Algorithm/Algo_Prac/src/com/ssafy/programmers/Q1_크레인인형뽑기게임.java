package com.ssafy.programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
1 5 3 5 1 2 1 4
 */
public class Q1_크레인인형뽑기게임 {
	static int[][] board;
	static int[] moves;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[5][5];
		moves = new int[8];
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 8; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}
		//-------------------------------------------------------
		
		int[][] map = new int[board.length][board.length];
        Stack<Integer> stack = new Stack<>();
        int[] index = new int[board.length];
        Arrays.fill(index, board.length);
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != 0) index[j]--;
            }
        }
        
        for(int j = 0; j < board.length; j++){
            for(int i = 0; i < board.length; i++){
                map[j][i] = board[i][j];
            }
        }
        
        int ans = 0;
        for(int i = 0; i < moves.length; i++){
            if(index[moves[i]-1] != board.length){
                int target = map[moves[i]-1][index[moves[i]-1]];
                if(stack.isEmpty()){
                    stack.push(target);
                } else {
                    if(stack.peek() == target){
                        stack.pop();
                        ans += 2;
                    } else {
                    	stack.push(target);
                    }
                }
                map[moves[i]-1][index[moves[i] - 1]] = 0;
                index[moves[i] - 1]++;
            } 
        }
//        int answer = stack.size();
        System.out.println(ans);
	}
}
