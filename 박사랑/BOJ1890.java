import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1890 {

	static int[][] map;
	static long[][] cnt;
	static int n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		cnt = new long[n][n];

		// input 입력받기
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cnt[0][0] = 1;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
                		if (map[r][c] == 0) // 움직일 수 없는 지점 pass
					continue;
				if (cnt[r][c] > 0) { // 점프할 수 있는 지점
					int next_c = c + map[r][c]; // 오른쪽으로 점프
					if (next_c < n) {
						cnt[r][next_c]+=cnt[r][c]; // 점프한 위치에 경우의수 더해주기
					}

					int next_r = r + map[r][c]; // 아래로 점프
					if (next_r < n) {
						cnt[next_r][c]+=cnt[r][c]; // 점프한 위치에 경우의수 더해주기
					}
				}
			}
		}
		System.out.println(cnt[n - 1][n - 1]);
	}
}
