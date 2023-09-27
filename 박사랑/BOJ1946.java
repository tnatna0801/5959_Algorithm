import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1946 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] rank = new int[n][2];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				rank[i][0] = Integer.parseInt(st.nextToken());
				rank[i][1] = Integer.parseInt(st.nextToken());
			}

			// 서류 성적으로 오름차순 정렬
			Arrays.sort(rank, (o1, o2) -> o1[0] - o2[0]);

			int result = 1;
			int min = rank[0][1];
			for (int i = 1; i < n; i++) {
				if (rank[i][1] < min) {
					min = rank[i][1];
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
