import java.util.*;

public class BOJ1699 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 11 에 대해
        // 1 -> 1 1+dp[0]
        // 2 -> 1,1 1+dp[1]
        // 3 -> 1,1,1 1+dp[2]
        // 4 -> 2 (2^2가 되므로 활용) 2+dp[0] 1+dp[3]
        // 5 -> 2,1 (2^2 쓰고 남은 1은 인덱스 1을 참조)
        // 6 -> 2,1,1
        // 7 -> 2,1,1,1
        // 8 -> 2,2
        // 9 -> 3
        // 10 -> 3,1
        // 11 -> 3,1,1
        // 12 -> 3+dp[3] 2+dp[8] 1+dp[11] ? 3
        // 13 -> 3+dp[4] 2+dp[9] 1+dp[12] ? 2

        int num = 1;
        int[] dp = new int[N+1];
        for(int i=0; i<N+1; i++)
            dp[i] = i;

        for(int i=1; i<=N; i++) {
            if((num+1)*(num+1) == i) {
                num += 1;
                dp[i] = 1;
            }
            else {
                for (int j = num; j >= 1; j--) {

                    if (dp[i] > dp[i - j * j] + 1)
                        dp[i] = dp[i - j * j] + 1;
                }
            }
        }

//        for(int i=0; i<=N; i++)
//            System.out.print(dp[i]+ " ");

        System.out.println(dp[N]);
    }
}
