package code.jam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reversort2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int cost = 0;
			for(int i = 0; i < N; i++) {
				int idx = 0, min = Integer.MAX_VALUE;
				for(int j = i; j < N; j++) {
					if(arr[j] < min) {
						idx = j;
						min = arr[j];
					}
				}
				reverse(arr, i, idx);
				cost += (idx - i + 1);
			}
			System.out.println("Case #" + t + ": " + (cost - 1));
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
}
