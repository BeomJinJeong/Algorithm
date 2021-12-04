package code.jam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DoubleOrNoting {
	static boolean[] check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			String E = st.nextToken();
			check = new boolean[Integer.parseInt("11111111", 2) + 2];
			bfs(S, E, t);
		}
	}
	private static void bfs(String s, String e, int t) {
		Queue<String> q = new LinkedList<>();
		check[Integer.parseInt(s, 2)] = true;
		q.add(s);
		
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				
				String cur = q.poll();
				if(cur.equals(e)) {
					System.out.println("Case #" + t + ": " + cnt);
					return;
				}
				
				String method1 = cur + "0";
				String method2 = cur.replace("1", "2");
				method2 = method2.replace("0", "1");
				method2 = method2.replace("2", "0");
				String method3 = "0";
				int m2Size = method2.length();
				for(int j = 0; j < m2Size; j++) {
					if(method2.substring(j, j + 1).equals("1")) {
						method3 = method2.substring(j, m2Size);
						break;
					}
				}
				int m1 = Integer.parseInt(method1, 2);
				int m2 = Integer.parseInt(method3, 2);
								
				if(m1 <= 256 && !check[m1]) {
					q.add(method1);
					check[m1] = true;
				}
				if(m2 <= 256 && !check[m2]) {
					q.add(method3);
					check[m2] = true;
				}
			}
			cnt++;
		}
		System.out.println("Case #" + t + ": " +"IMPOSSIBLE");
	}
}
