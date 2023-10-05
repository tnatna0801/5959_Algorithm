import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1699 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        if(N<=3) {
            System.out.println(N);
            return;
        }
        int max= (int) Math.sqrt(N); // 제곱근 중에 제일 큰 값
        int[] dp=new int[N+1];
        for(int i=1;i<=N;i++){
            dp[i]=i;
        }
        for(int sqrt=2;sqrt<=max;sqrt++){
            int start=sqrt*sqrt;
            dp[start]=1;
            for(int i=start+1;i<=N;i++){
                dp[i]=Math.min(dp[i],dp[start]+dp[i-start]);
            }
        }
        System.out.println(dp[N]);
    }
}
