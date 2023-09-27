import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ15989 {
    static int T, N;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        dp = new int[10001][4];

        // dp배열 초기화
        for(int i=1; i<=3; i++) {
            for(int j=1; j<=i; j++) {
                dp[i][j] = 1;
            }
        }

        // dp[i][j] : 구하려는 수 i를 j 이하의 숫자로만 만들 수 있는 경우의 수
        for(int i=4; i<=10000; i++) {
            // i를 만들 때 1로 끝나는 경우는 i-1을 만드는 경우에 1로 끝날 때 1 더하기
            dp[i][1] = dp[i-1][1];
            // 2로 끝나는 경우는 i-2를 만드는 경우에 1,2로 끝날 때 2 더하기
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            // 3으로 끝나는 경우는 i-3 만드는 경우에 1,2,3으로 끝날 때 3 더하기 
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
        
        // T번만큼 N을 1이하,2이하,3이하 숫자로 만드는 경우들을 더하기
        for(int t=0; t<T; t++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N][1] + dp[N][2] + dp[N][3]+"\n");
        }
        System.out.println(sb.toString());
    }
}
