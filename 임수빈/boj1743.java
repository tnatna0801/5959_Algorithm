import java.io.*;
import java.util.*;

public class boj1743 {

    static int n, m;
    static boolean[][] visited;
    static int answer = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 음식물 표시
        visited = new boolean[n][m];
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            visited[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        visited[x][y] = false; // 방문 표시
        int cnt = 1; // 음식물 크기


        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            x = q[0];
            y = q[1];

            for (int i=0; i<4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= m) {
                    continue;
                }

                if (!visited[mx][my]) {
                    continue;
                }

                // 음식물이 인접해있는 경우
                cnt++;
                queue.add(new int[]{mx, my});
                visited[mx][my] = false; // 방문 표시
            }
        }

        answer = Math.max(answer, cnt);
    }
}
