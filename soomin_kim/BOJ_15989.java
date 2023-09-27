import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=t; tc++){

            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[10001][4];
            // [n][1] : n을 만드는 연산인데 1로 끝나는 경우의 수
            // [n][2] : n을 만드는 연산인데 2로 끝나는 경우의 수
            // [n][2] : n을 만드는 연산인데 3로 끝나는 경우의 수

            //초기화
            dp[1][1] = 1; // 1
            dp[2][1] = 1; // 1+1
            dp[2][2] = 1; // 2
            dp[3][1] = 1; // 1+1+1
            dp[3][2] = 1; // 1+2
            dp[3][3] = 1; // 3


            for(int i = 4; i<=n; i++){
                dp[i][1] = dp[i-1][1]; // dp[4][1] = dp[3][1] = > 1+1+1+1 한가지
                dp[i][2] = dp[i-2][1] + dp[i-2][2]; // dp[4][2] = dp[2][1] + dp[2][2] => 1+1, 2 에 각각 2를 더해서 만들 수 있으므로 2가지
                dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
            }


            sb.append(dp[n][1] + dp[n][2] + dp[n][3] + "\n");

        }
        System.out.println(sb);
    }
}
