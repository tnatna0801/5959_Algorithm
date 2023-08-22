import java.util.*;
import java.io.*;

public class Main {
    static int N, map[][];
    static long dp[][];
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dp[0][0]=1;

        // for 문을 돌면서 해당 값을 지나가는 만큼 더해 준다 (오른쪽, 아래)
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(dp[i][j]==0 || (i==N-1&&j==N-1)) // 도착하면 계산 x
                    continue;

                int x = i+map[i][j];
                int y = j+map[i][j];

                if(x<N)
                    dp[x][j] += dp[i][j];

                if(y<N)
                    dp[i][y] += dp[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
