import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S1890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        // 오른쪽과 아래쪽으로 점프!
        int[] dx = { 1, 0 };
        int[] dy = { 0, 1 };

        // 입력받아용
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 경로를 누적할 dp 배열
        long[][] dp = new long[n][n];
        dp[0][0] = 1; // 출발지점은 1로 초기화한다.

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int jump = map[i][j];
                if(jump == 0) break;
                for (int k = 0; k < 2; k++) { // 아래, 오른쪾 확인

                    int nextX = i + dx[k] * jump;
                    int nextY = j + dy[k] * jump;
                    if (nextX >= n || nextY >= n)
                        continue;
                    //i,j에서 가는 방법 + 다른 곳에서 가능 방법이 있기때문에 다 더해줘야한다.
                    dp[nextX][nextY] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}


