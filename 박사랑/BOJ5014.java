import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {

	static class Floor {
		int f;
		int cnt;

		public Floor(int f, int cnt) {
			this.f = f;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F, S, G, U, D;
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		int[] result = new int[F + 1]; // idx층까지 몇 번만에 왔는지
		Arrays.fill(result, Integer.MAX_VALUE);
		int[] move = { U, -D };

		// BFS
		Queue<Floor> q = new LinkedList<>();
		q.add(new Floor(S, 0)); // 시작 지점
		result[S] = 0;
		while (!q.isEmpty()) {
			Floor now = q.poll();
			for (int i = 0; i < 2; i++) {
				int next = now.f + move[i]; // 현재 층에서 Up/Down
				if (next <= 0 || next > F) // 범위를 벗어남
					continue;
				if (result[next] <= now.cnt + 1) // 이미 최단 거리로 옴
					continue;
				result[next] = now.cnt + 1;
				q.add(new Floor(next, now.cnt + 1));
			}
		}
		if(result[G]==Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		}else {
			System.out.println(result[G]);	
		}
	}
}
