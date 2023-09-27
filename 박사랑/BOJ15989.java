import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15989 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dp = new int[3][10001];
		for (int i = 1; i <= 10000; i++) {
			dp[0][i] = 1;
		}
		dp[1][2] = 1;
		dp[1][3] = 1;
		dp[2][3] = 1;
		for (int i = 4; i <= 10000; i++) {
			dp[1][i] = dp[1][i - 2] + dp[0][i - 2];
			dp[2][i] = dp[2][i - 3] + dp[1][i - 3] + dp[0][i - 3];
		}
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int n=Integer.parseInt(br.readLine());
			System.out.println(dp[0][n]+dp[1][n]+dp[2][n]);
		}
	}
}
