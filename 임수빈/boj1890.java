import java.io.*;
import java.util.*;

public class boj1890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 배열
        long[][] result = new long[n][n];
        result[0][0] = 1; // 출발지

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                // 도착지에 도달하면 멈춤
                if (i == n-1 && j == n-1) {
                    break;
                }

                // 건너뛸 칸의 수
                int move = board[i][j];

                // 아래로 점프
                if (i + move < n) {
                    result[i + move][j] += result[i][j];
                }

                // 오른쪽으로 점프
                if (j + move < n) {
                    result[i][j + move] += result[i][j];
                }
            }
        }

        System.out.println(result[n-1][n-1]);
    }
}
