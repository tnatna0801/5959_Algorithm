import java.util.*;
import java.io.*;

class BOJ2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2; i<=N; i++)
        	dp[i]=dp[i-1]+dp[i-2];
        
        int result = 1;
        int pre = 0;
        for(int i=0; i<M; i++) {
        	int n = Integer.parseInt(br.readLine());
        	result *= dp[n-pre-1];
        	pre = n;
        }
        result *= dp[N-pre];
        
        System.out.println(result);
    }
}
