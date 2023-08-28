import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1303 {

	static int N, M;
	static char[][] map;
	static int[] dr = { 1, 0, -1, 0 }; // 아래, 오른쪽, 위쪽, 왼쪽
	static int[] dc = { 0, 1, 0, -1 };

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 가로(열) 크기
		M = Integer.parseInt(st.nextToken()); // 세로(행) 크기
		map = new char[M][];
		boolean[][] visit_w = new boolean[M][N];
		boolean[][] visit_b = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[i] = st.nextToken().toCharArray();
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'W') {
					visit_w[i][j] = true;
				} else if (map[i][j] == 'B') {
					visit_b[i][j] = true;
				}
			}
		}

		// 우리팀(W)
		int answer_w = bfs(0,visit_w);

		// 적팀(B)
		int answer_b = bfs(0,visit_b);
		System.out.println(answer_w + " " + answer_b);
	}
	
	public static int bfs(int answer,boolean[][] visit) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j]) {
					int cnt = 1; // 몇명 있는지
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i, j));
					visit[i][j] = false;
					while (!q.isEmpty()) {
						Point now = q.poll();
						int r = now.r;
						int c = now.c;
						for (int dir = 0; dir < 4; dir++) {
							int next_r = r + dr[dir];
							int next_c = c + dc[dir];
							if (next_r < 0 || next_r >= M || next_c < 0 || next_c >= N) // map을 벗어남
								continue;

							if (!visit[next_r][next_c]) // 다른팀 이거나 이미 왔던 곳
								continue;
							q.offer(new Point(next_r, next_c));
							visit[next_r][next_c] = false;
							cnt++;
						}
					}
					answer += cnt * cnt;
				}
			}
		}
		return answer;
	}
}
