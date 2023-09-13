import java.io.*;
import java.util.*;

public class boj5014 {

    static int F, S, G, U, D;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 총 층수
        S = Integer.parseInt(st.nextToken()); // 시작 층
        G = Integer.parseInt(st.nextToken()); // 도착 층
        U = Integer.parseInt(st.nextToken()); // 위로
        D = Integer.parseInt(st.nextToken()); // 아래로

        visited = new boolean[F+1];
        visited[S] = true;

        int answer = bfs();
        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }

    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});

        while (!queue.isEmpty()) {
            int q[] = queue.poll();
            int x = q[0];
            int cnt = q[1];

            // 도착
            if (x == G) {
                return cnt;
            }

            // 위로 이동
            if (x + U <= F && !visited[x+U]) {
                visited[x+U] = true;
                queue.add(new int[]{x+U, cnt+1});
            }

            // 아래로 이동
            if (x - D > 0 && !visited[x-D]) {
                visited[x-D] = true;
                queue.add(new int[]{x-D, cnt+1});
            }
        }

        // 이동 불가능한 경우
        return -1;
    }
}
