import java.util.*;
import java.io.*;

public class BOJ_1189
{

    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result;

    static void dfs(int x, int y, int k){

        if (k > K) return; // 현재 이동 거리가 찾고자 하는 거리보다 크다면 바로 종료
        if (x == 0 && y == C-1){ // 집에 도착했다면
            if (k==K-1) result++; // 찾고자 한 이동거리면 결과에 1을 더함
            return; // 종료
        }

        // dfs
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

            if (!visited[nx][ny] && map[nx][ny] == '.'){
                visited[nx][ny] = true;
                dfs(nx, ny, k+1);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }
        visited[R-1][0] = true;
        dfs(R-1, 0, 0);

        System.out.println(result);
    }
}
