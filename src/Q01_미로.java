import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q01_미로 {
	int[][] map;
	int size;
	boolean[][] check;
	Integer[] arr;
	int pos;
	int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; // 왼위오아
	public Q01_미로(int size) {
		super();
		this.size = size;
		this.map = new int[size][size];
		this.check = new boolean[size][size];
	}
	
	public void add(int a) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < a; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}
	public void bfs() {
		Queue<Integer[]> q = new LinkedList<>();
		arr = new Integer[2];
		int i = 0, j = 0;
		arr[0] = i; arr[1] = j;
		q.offer(arr);
		int current = -1;
		
		while(!q.isEmpty()){
			arr = q.poll();
			for(int k = 0; k < 4; k++) {
				int nx = arr[0] + dir[k][1];
				int ny = arr[1] + dir[k][0];
				if( nx < 0 | nx >= size | ny < 0 | ny >= size ) continue;
				if(map[ny][nx] == 0) {
					arr[0] = ny; arr[1] = nx;
					q.offer(arr);
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
