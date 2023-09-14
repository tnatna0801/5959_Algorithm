import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1189 {

    static int N, M, K, result;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0}; // 상우하좌
    static int[] dc = {0, 1, 0, -1}; // 상우하좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        result = 0;
        boolean[][] visit = new boolean[N][M];
        visit[N - 1][0] = true;
        dfs(N - 1, 0, 1, visit);
        System.out.println(result);
    }

    public static void dfs(int r, int c, int k, boolean[][] visit) {
        if (k == K) {
            if (r == 0 && c == M - 1) // 도착지점
                result++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int next_r = r + dr[i];
            int next_c = c + dc[i];
            if (next_r < 0 || next_r >= N || next_c < 0 || next_c >= M) continue;
            if (map[next_r][next_c] == 'T') continue;

            if (!visit[next_r][next_c]) {
                visit[next_r][next_c] = true;
                dfs(next_r, next_c, k + 1, visit);
                visit[next_r][next_c] = false;
            }
        }
    }
}
