package code.jam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MoonAndUmbrellas {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int CJcost = Integer.parseInt(st.nextToken());
			int JCcost = Integer.parseInt(st.nextToken());
			char[] s = st.nextToken().toCharArray();
			int sum = 0;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < s.length; i++) {
				if(s[i] != '?') sb.append(s[i]);
			}
			for(int i = 0; i < sb.length() - 1; i++) {
				if(sb.toString().substring(i, i + 2).equals("CJ")) sum += CJcost;
				else if(sb.toString().substring(i, i + 2).equals("JC")) sum += JCcost;
			}
			System.out.println("Case #" + t + ": " + sum);
		}
	}
}
