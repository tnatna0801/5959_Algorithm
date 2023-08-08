import java.io.*;
import java.util.*;

// 백준 2468: 안전 영역
public class boj2468 {

	static int n;
	static int[][] area;
	static boolean[][] visited;
	static boolean[][] temp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		area = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int h = 0;
		int answer = 0;
		int cnt;
		
		while (h <= 100) {
			sink(h); // 물에 잠기는 지점 표시
	
			cnt = 0;
			temp = cloneArray(); // visited 복사
			
			// 안전한 영역 찾기
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (!temp[i][j]) {
						findSafeArea(i, j);
						cnt++;
					}
				}
			}
			
			// 최댓값 갱신
			answer = Math.max(answer, cnt);
			
			// 물에 잠기는 높이 추가
			h++;	
		}
		
		System.out.println(answer);
		
	}
	
	static void sink(int h) {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (area[i][j] == h) {
					visited[i][j] = true;
				}
			}
		}
	}
	
	static boolean[][] cloneArray() {
		boolean[][] temp = new boolean[n][n];
		
		for (int i=0; i<n; i++) {
			System.arraycopy(visited[i], 0, temp[i], 0, n);
		}
		
		return temp;
	}
	
	static void findSafeArea(int x, int y) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		int mx, my;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			x = q[0];
			y = q[1];
			
			for (int i=0; i<4; i++) {
				// 좌표 이동
				mx = x + dx[i];
				my = y + dy[i];
				
				// 영역을 벗어난 경우
				if (mx < 0 || mx >= n || my < 0 || my >= n) {
					continue;
				}
				
				// 이미 물에 잠긴 영역이거나 방문한 적 있는 영역인 경우
				if (temp[mx][my]) {
					continue;
				}
				
				// 방문 체크
				temp[mx][my] = true;
				queue.add(new int[] {mx, my});
			}
		}
		
	}
	

}
