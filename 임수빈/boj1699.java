import java.io.*;

public class boj1699 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		for (int i=1; i<=n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for (int i=1; i<=Math.sqrt(n); i++) {
			// 제곱수인 경우 1
			int k = i * i;
			dp[k] = 1;
			
			// 다음 제곱수가 나올 때까지의 값을 갱신
			for (int j=k; j<=n; j++) {
				dp[j] = Math.min(dp[j], dp[k] + dp[j-k]);
			}
		}

		System.out.println(dp[n]);
	}

}
