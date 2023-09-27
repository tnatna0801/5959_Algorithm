import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743 {
	
	static int N, M, K;
	static boolean[][] waste;
	
	static Queue<int[]> queue;
	static int maxSize;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	
	static boolean boundaryCheck(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return false;
		else
			return true;
	}
	
	static int bfs() {
		int cnt = 0;
		while(!queue.isEmpty()) {
			cnt++; // 음식물의 크기 카운트
			int[] pos = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				
				// 범위를 넘거나 음식물이 없으면(이 영역에 포함X면)
				if (!boundaryCheck(nx, ny) || !waste[nx][ny]) continue;
				
				// 찾은 자리가 음식물이라면!
				queue.offer(new int[] {nx, ny});
				waste[nx][ny] = false;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		queue = new ArrayDeque<int[]>();
		
		waste = new boolean[N][M];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			waste[x][y] = true; // 음쓰 표시
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				// 현재 위치에 음식물이 있다면, 그 크기가 얼만큼 큰지 bfs로 확인
				if (waste[i][j]) {
					queue.offer(new int[] {i, j});
					// bfs에서 돌 때 시작점을 다시 돌지 않도록
					waste[i][j] = false;
					maxSize = Math.max(maxSize, bfs());
				}
			}
		}
		
		System.out.println(maxSize);
	}
}
