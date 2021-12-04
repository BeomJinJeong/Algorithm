import java.util.Arrays;
import java.util.Scanner;

public class Q01_미로테스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			Q01_미로 m = new Q01_미로(N);
			m.add(N);
			
			m.bfs();
		}
	}
}
