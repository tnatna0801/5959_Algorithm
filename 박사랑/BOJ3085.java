import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ3085 {

	static int n, result;
	static char[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new char[n][n];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		result = 0;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n - 1; j++) {
				swap_col(i, j); 
				check_col(j);
				check_col(j + 1);
				check_row(i);
				swap_col(i, j);

				//

				swap_row(j, i);
				check_row(j);
				check_row(j + 1);
				check_col(i);
				swap_row(j, i);
			}
		}

		System.out.println(result);

	}

	public static void swap_row(int row, int col) {
		char tmp = map[row][col];
		map[row][col] = map[row + 1][col];
		map[row + 1][col] = tmp;
	}

	public static void swap_col(int row, int col) {
		char tmp = map[row][col];
		map[row][col] = map[row][col + 1];
		map[row][col + 1] = tmp;
	}

	public static void check_row(int row) {
		int prev = map[row][0];
		int max = 1;
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			int cur = map[row][i];
			if (cur == prev) {
				cnt++;
				max = Math.max(max, cnt);
			} else {
				max = Math.max(max, cnt);
				cnt = 1;
			}
			prev = cur;
		}

		result = Math.max(result, max);
	}

	public static void check_col(int col) {
		int prev = map[0][col];
		int max = 1;
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			int cur = map[i][col];
			if (cur == prev) {
				cnt++;
				max = Math.max(max, cnt);
			} else {
				max = Math.max(max, cnt);
				cnt = 1;
			}
			prev = cur;
		}

		result = Math.max(result, max);
	}

}