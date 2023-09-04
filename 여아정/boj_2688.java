package cocodingding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2688 {
	static long dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] num = new int[T];
		dp = new long[76][76];//최대가능 N 64에 숫자 계산 계산시 +9하므로 75까지 가능하도록 구성
		bino();

		for (int i = 0; i < T; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sb.append(dp[9 + num[i]][num[i]] + "\n");// 10-n-1Cn 공식을 이용
		}

		System.out.print(sb.toString());

	}

	private static void bino() {
		for (int i = 0; i < 76; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];//iCj의 조합 값을 갱신
			}
		}
	}

}
