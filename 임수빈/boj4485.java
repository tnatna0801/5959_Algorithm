import java.io.*;
import java.util.*;

public class boj4485 {

	static int n;
	static int[][] cave;
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		
		while (true) {
			n = Integer.parseInt(br.readLine());
			
			cave = new int[n][n]; // 동굴 입력
			result = new int[n][n]; // 각 칸의 총 잃은 도둑루피
			
			// 0이 입력되면 종료
			if (n == 0) {
				break;
			}
			
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				for (int j=0; j<n; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					result[i][j] = Integer.MAX_VALUE; // 최댓값으로 초기화
				}
			}
			
			bfs();
			sb.append("Problem " + (t++) + ": " + result[n-1][n-1] + "\n");
		}
		
		System.out.print(sb);
		
	}
	
	static void bfs() {
		// 이동 배열
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		
		// 출발지
		result[0][0] = cave[0][0];
		
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int x = q[0];
			int y = q[1];
			
			for (int i=0; i<4; i++) {
				// 이동 좌표
				int mx = x + dx[i];
				int my = y + dy[i];
				
				// 인덱스 범위를 벗어나면 통과
				if (mx < 0 || mx >= n || my < 0 || my >= n) {
					continue;
				}
				
				// 최솟값 갱신
				if (cave[mx][my] + result[x][y] < result[mx][my]) {
					result[mx][my] = cave[mx][my] + result[x][y];
					queue.add(new int[] {mx, my});
				}
			}
		}
	}

}
