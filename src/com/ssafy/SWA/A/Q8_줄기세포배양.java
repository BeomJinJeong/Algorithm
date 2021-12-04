package com.ssafy.SWA.A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q8_줄기세포배양 {
	static int[][] dir = {{1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static class Cell implements Comparable<Cell>{
		int r, c;
		int life, wait;	// 생명력, 대기시간
		int time;	// 현재가 몇 시간째
		boolean isActivated; // 활성화 여부
				
		public Cell(int r, int c, int life, int wait, int time) {
			super();
			this.r = r;
			this.c = c;
			this.life = life;
			this.wait = wait;
			this.time = time;
			isActivated = wait == 0;
		}

		// 턴을 중심으로 동작하며 그 중에서 생명력 높은 놈이 먼저..
		@Override
		public int compareTo(Cell o) {
			int diff = this.time - o.time;
			return diff == 0 ? o.life - this.life : diff;
		}
		
	}
	static int T, N, M, K;
	static boolean[][] visited;
	static PriorityQueue<Cell> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			// 세포는 번식함으로 번식 시간인 K가 개입
			visited = new boolean[N + K][M + K];
			q = new PriorityQueue<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {					
					int life = Integer.parseInt(st.nextToken());
					if(life > 0) {
						Cell cell = new Cell(i + K/2, j + K/2, life, life, 0);
						//선점되어 있으면 다른 녀석들은 못옴
						visited[cell.r][cell.c] = true;
						q.offer(cell);
					}
				}
			}
			incubate();
			System.out.println("#" + t + " " + q.size());
		}
	}
	// K 시간의 변화를 살펴보자.
	static void incubate() {
		while(!q.isEmpty()) {
			// 맨 처음 세포 가져오기
			Cell head = q.poll();
			
			// 사용하기. 가져온 세포의 시간이 K와 같다면 실험 끝
			if(head.time == K) {
				q.offer(head);
				break;
			}
			
			// 아직 세포가 비활성화 된 상태라면? -> 대기시간을 줄인다. 그러다 0이 되면 활성화가 된다. 그리고 다시 관리
			if(!head.isActivated) {
				if(--head.wait == 0) {
					head.isActivated = true;
				}
				head.time++;
				q.offer(head);
			}
			// 세포가 이미 활성화 된 상태라면? -> 사방탐색으로 번식, head의 생명력 - 1, 생명력이 0이 된다면 사망 (q에서 관리하지 않는다.)
			else {
				// 세포가 확장하는 것 처리
				for(int i = 0; i < 4; i++) {
					int ny = head.r + dir[i][0];
					int nx = head.c + dir[i][1];
					
					// 범위를  벗어날 일은 없음. 그럼 ny, nx에 갈 수 있나?? -> 이미 선점하고 있으면 갈 수 없음.
					if(!visited[ny][nx]) {
						visited[ny][nx] = true;
						// 세포 확장 
						q.offer(new Cell(ny, nx, head.life, head.life, head.time + 1));
					}
				}
				// 원래 있던 세포 처리 -> life가 줄어든다. --> 여전히 살아있으면 다시 관리, 아니면 사망				
				if(--head.life > 0) {
					head.time++;
					q.offer(head);
				}
			}
		}
	}
}
