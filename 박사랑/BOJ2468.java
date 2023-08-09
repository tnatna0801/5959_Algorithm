import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, answer;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { 0, 1, -1, 0 }; // 오른쪽, 아래, 위, 왼쪽
	static int[] dc = { 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N]; // default false

		int max = 0; // 지역 높이 최댓값
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (map[i][j] > max) // 지역 높이 최댓값 구하기
					max = map[i][j];
			}
		}

		answer = 1;
		
		for (int rain = 1; rain < max; rain++) { // 빗물의 높이 1~max-1일 때 안전지대가 몇개인지 알아보자
			int cnt=0; // 안전지대 갯수
			visit = new boolean[N][N]; // default false
			for (int i = 0; i < N; i++) { // 잠기지 않은 곳을 true로 입력
				for (int j = 0; j < N; j++) {
					if (map[i][j] > rain)
						visit[i][j] = true;
				}
			}

      // dfs로 탐색
			for (int i = 0; i < N; i++) { 
				for (int j = 0; j < N; j++) {
					if (visit[i][j]) { // 잠기지 않은 곳
						cnt++;
						dfs(i, j);
					}
				}
			}
			answer=Math.max(answer, cnt);
		}
		System.out.println(answer);
	}

	public static void dfs(int row, int col) {

		if (row >= N || col >= N || row < 0 || col < 0) {
			return;
		} else if (!visit[row][col]) {
			return;
		}
		visit[row][col] = false;

		for (int i = 0; i < 4; i++) {
			int next_r = row + dr[i];
			int next_c = col + dc[i];
			dfs(next_r, next_c);
		}
	}
}
