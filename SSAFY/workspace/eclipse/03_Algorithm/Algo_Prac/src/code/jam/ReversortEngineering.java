package code.jam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReversortEngineering {
	static int cost, N;
	static int[] res;
	static boolean[] check;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			res = new int[N];
			check = new boolean[N];
			
			perm(0);
			
			StringBuilder sb = new StringBuilder();
			sb.append("Case #").append(t).append(": ");
			if(flag) {
				for(int i : res) {
					sb.append(i).append(" ");
				}
			} else sb.append("IMPOSSIBLE");
			System.out.println(sb);
			flag = false;
		}
	}
	private static void reverse(int[] arr, int i, int j) {
		int temp = 0;
		while(i <= j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	private static boolean perm(int cnt) {
		if(flag) return false;
		if(cnt == N) {
			int[] tmp = new int[N];
			for(int i = 0; i < N; i++) {
				tmp[i] = res[i];
			}
			int c = 0;
			for(int i = 0; i < N; i++) {
				int idx = 0, min = Integer.MAX_VALUE;
				for(int j = i; j < N; j++) {
					if(tmp[j] < min) {
						idx = j;
						min = tmp[j];
					}
				}
				reverse(tmp, i, idx);
				c += (idx - i + 1);
			}
			if(c - 1 == cost) {
				flag = true;
				return true;
			}
			return false;
		}
		for(int i = 0; i < N; i++) {
			if(!check[i]) {
				res[cnt] = i + 1;
				check[i] = true;
				if(perm(cnt + 1)) return true;
				check[i] = false;
			}
		}
		return false;
	}
}
