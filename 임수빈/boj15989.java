import java.io.*;

public class boj15989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // n <= 10000
        int[][] dp = new int[10001][4];
        // 1 ~ 3 초기값
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i=4; i<=10000; i++) {
            // 1로 끝나는 수 -> 1 작은 수에 1 더하기
            dp[i][1] = dp[i-1][1];
            // 2로 끝나는 수 -> 2 작은 수에 2 더하기
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            // 3으로 끝나는 수 -> 3 작은 수에 3 더하기
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
        }

        System.out.print(sb);
    }
}
