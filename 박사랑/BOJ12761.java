import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12761 {

	static int A, B, N, M;
	static int[] visit, move;

	static class Position {
		int idx;
		int cnt;

		public Position(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new int[100001]; // idx칸까지 몇번 점프해서 왔는지 표시
		Arrays.fill(visit, Integer.MAX_VALUE);
		move = new int[] { A, B, -1, 1, -A, -B };

		// BFS 시작
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(N, 0));
		visit[N] = 0;
		while (!q.isEmpty()) {
			Position now = q.poll();
			visit[now.idx] = now.cnt;
			// A,B만큼 좌우로 점프, 한칸 좌우로 점프
			for (int i = 0; i < 6; i++) {
				int next = now.idx + move[i];
				if (next < 0 || next > 100000) // 범위를 벗어남
					continue;
				if (visit[next] <= now.cnt + 1) // 이미 방문했음
					continue;
				visit[next] = now.cnt + 1;
				q.offer(new Position(next, now.cnt + 1));
			}
			// A배 B배 점프
			for (int i = 0; i < 2; i++) {
				int next = now.idx * move[i];
				if (next > 100000) // 범위를 벗어남
					continue;
				if (visit[next] <= now.cnt + 1) // 이미 방문했음
					continue;
				visit[next] = now.cnt + 1;
				q.offer(new Position(next, now.cnt + 1));
			}
		}
		System.out.println(visit[M]);
	}
}
