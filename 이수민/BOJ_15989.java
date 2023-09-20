import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15989 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];

        // 전처리 값들
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i=4; i<10001; i++){
            dp[i] = dp[i-1] + dp[i-2] - dp[i-3]; // 점화식
            if (i%3==0) dp[i]++; // i가 3의 배수인 경우
        }

        for(int t=0; t<T; t++)
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");

        System.out.println(sb);
    }
}
