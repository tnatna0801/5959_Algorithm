import java.util.*;
import java.io.*;

public class BOJ1890 {
    static int N;
    static int[][] arr; // 거리 입력 받는 배열
    static long[][] dp; // 경로 개수 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new long[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1; // 시작점 방문
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int dist = arr[i][j]; // 현재 칸에서 갈 수 있는 거리
                if(dist == 0) // 목적지 도착
                    break;
                if(i+dist < N) { // 아래로 이동 가능하다면
                    dp[i+dist][j] += dp[i][j]; // 이동할 칸에 경로 개수 더하기
                }
                if(j+dist < N) { // 오른쪽으로 이동 가능하다면
                    dp[i][j+dist] += dp[i][j]; // 이동할 칸에 경로 개수 더하기
                }
            }
        }
        System.out.println(dp[N-1][N-1]); // 총 경로 개수 출력
    }
}
