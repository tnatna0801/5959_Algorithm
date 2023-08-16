import java.io.*;
import java.util.*;

public class BOJ4485 {
    static int N, min;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map, dp;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 테스트 케이스 수
        int t = 0;

        // 입력 받기
        N = Integer.parseInt(br.readLine());

        while (N != 0) {
            ++t;
            map = new int[N][N];
            dp = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    dp[i][j] = Integer.MAX_VALUE;

            bfs(0, 0, map[0][0]);

            // 그래서 탐색이 끝나고 N-1, N-1 좌표의 값을 출력한다
            System.out.println("Problem " + t + ": " + dp[N-1][N-1]);

            N = Integer.parseInt(br.readLine());
        }
    }

    static void bfs(int x, int y, int distance) {
        // 맵을 bfs, dp로 탐색하기
        // 0, 0 좌표에서 4방향 돌면서, 현재 값에 해당 지점 더했을 때의 최솟값을 저장하는 걸 반복한다

        Queue<int[]> q = new ArrayDeque<int[]>();

        q.add(new int[]{x,y,distance});

        while(!q.isEmpty()) {

            // q에 있던 걸 꺼내서 1차 탐색
            int[] info = q.poll();

            // 4방향 탐색 후에, 값 비교해서 큐에 다 저장
            // q에 있던 걸 꺼내서 2차 탐색 ... n 차 탐색까지 진행
            for (int i = 0; i < 4; i++) {
                int xx = info[0] + dx[i];
                int yy = info[1] + dy[i];
                int dist = info[2];

                if (xx < 0 || xx >= N || yy < 0 || yy >= N)
                    continue;

                dist += map[xx][yy];

                // 현재 값이 더 최솟값이면 진행한다
                if (dp[xx][yy] > dist)
                    dp[xx][yy] = dist;
                else
                    // 최솟값이 아니면 그쪽 방향 탐색은 그냥 종료한다
                    continue;

                q.add(new int[] {xx, yy, dist});
            }
        }
    }
}
