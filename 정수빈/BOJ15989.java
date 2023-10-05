import java.util.*;

public class BOJ15989 {
    static int T, n, dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int t=1; t<=T; t++) {
            // 1 2 3 합으로 나타내는 방법의 수
            n = sc.nextInt();

            dp = new int[n+1];

            // 1에 대한 경우 더하기
            Arrays.fill(dp, 1);

            // 2에 대한 경우 더하기
            for(int i=2; i<=n; i++) {
                dp[i] += dp[i-2];
            }

            // 3에 대한 경우 더하기
            for(int i=3; i<=n; i++) {
                dp[i] += dp[i-3];
            }

            System.out.println(dp[n]);
        }
    }
}
