package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1699 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int dp[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			dp[i] = i;
			for (int j = 1; j * j <=i; j++) {
				if (i - (j * j) >= 0 && dp[i] > dp[i - (j * j)] + 1) {//현재 dp[i]보다 더 최소라면 갱신 ㄱ ㄱ
					dp[i] = dp[i - (j * j)] + 1;//i-(j*j)의 최소 제곱수합 +1
				}
			}
		}
		System.out.println(dp[N]);

	}
}
