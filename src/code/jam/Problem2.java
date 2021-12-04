package code.jam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2 {
	static int n ;
	static int[] input; // 0 : C J : 1 ? : 2
	static int[][] dp;
	static int cost[] = new int[2];
	static int count[];// x , y
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine()," ");
			result  = Integer.MAX_VALUE;
			cost[1] = Integer.parseInt(st.nextToken());
			cost[0] = Integer.parseInt(st.nextToken());
			String command = st.nextToken();
			n = command.length();
			input = new int[n];
			dp = new int[n][2];
			count = new int[2]; // x , y
			for(int i = 0 ; i < n ; i++) {
				if(command.charAt(i) == 'C') {
					input[i] = 0;
				}else if(command.charAt(i) == 'J') {
					input[i] = 1;
				}else {
					input[i] = 2;
				}
				dp[i][1] = Integer.MAX_VALUE;
				dp[i][0] = Integer.MAX_VALUE;
			}
			dp[0][0] = 0;
			dp[0][1] = 0;
			for(int k = 1 ; k < n ; k++) {
				if(input[k-1] == 2 && input[k] == 2) {
					for(int i = 0 ; i < 2 ; i++) {
						for(int j = 0 ; j < 2; j++) {
							if(i + j == 1) {
								dp[k][j] = Math.min(dp[k][j], dp[k-1][i] + cost[j]);
							}else {
								dp[k][j] = Math.min(dp[k][j], dp[k-1][i]);
							}
						}
					}
				}else if(input[k-1] == 2){
					for(int i = 0 ; i < 2 ; i++) {
						if(i + input[k] == 1) {
							dp[k][input[k]] = Math.min(dp[k][input[k]], dp[k-1][i] + cost[input[k]]);
						}else {
							dp[k][input[k]] = Math.min(dp[k][input[k]], dp[k-1][i] );
						}
					}
				}else if(input[k] == 2) {
					for(int i = 0 ; i < 2 ; i++) {
						if(i + input[k-1] == 1) {
							dp[k][i] = Math.min(dp[k][i], dp[k-1][input[k-1]] + cost[i]);
						}else {
							dp[k][i] = Math.min(dp[k][i], dp[k-1][input[k-1]]);
						}
					}
				}else {
					if(input[k] + input[k-1] == 1) {
						dp[k][input[k]] = Math.min(dp[k][input[k]], dp[k-1][input[k-1]] + cost[input[k]]);
					}else {
						dp[k][input[k]] = Math.min(dp[k][input[k]], dp[k-1][input[k-1]]);
					}
				}
			}
			result = Math.min(dp[n-1][0], dp[n-1][1]);
			System.out.printf("Case #%d: %d\n" , t , result);
		}
	}
}


