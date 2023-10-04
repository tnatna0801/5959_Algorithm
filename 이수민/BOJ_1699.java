import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1699 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        // dp 값 초기화 - 1만을 이용한 제곱수의 합
        for(int i=1; i<=n; i++)
            dp[i] = i;

        for(int i=1; i<=n; i++){
            // i보다 작은 제곱수를 이용하는 경우를 고려
            for(int j=1; j*j<=i; j++){
                if (dp[i] > dp[i-j*j]+1){ // 현재 제곱수 사용으로 항을 더 적게 만들 수 있는 경우
                    dp[i] = dp[i-j*j]+1; // j*j 제곱수를 사용한 식으로 변경
                }
            }
        }

        System.out.println(dp[n]);

    }
}
