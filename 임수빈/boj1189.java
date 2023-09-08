import java.io.*;
import java.util.*;

public class boj1189 {

    static int r, c, k;
    static int answer = 0;
    static char[][] board;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        for (int i=0; i<r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visited = new boolean[r][c];
        visited[r-1][0] = true;
        find(r-1, 0, 1);

        System.out.println(answer);
    }

    static void find(int x, int y, int cnt) {
        // 거리가 k일 경우
        if (cnt == k) {
            // 도착했으면 정답 추가
            if (x == 0 && y == c-1) {
                answer++;
            }
            return;
        }
        for (int i=0; i<4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            // 범위를 벗어나면 넘어간다.
            if (mx < 0 || mx >= r || my < 0 || my >= c) {
                continue;
            }

            // 갈 수 없는 칸이면 넘어간다.
            if (board[mx][my] == 'T') {
                continue;
            }

            // 이미 방문한 칸이면 넘어간다.
            if (visited[mx][my]) {
                continue;
            }

            visited[mx][my] = true;
            find(mx, my, cnt+1); // 다음 방문
            visited[mx][my] = false;
        }
    }
}
