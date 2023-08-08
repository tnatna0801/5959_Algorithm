import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {

    static int n;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        //1. 입력받기 + 건물 최대 높이 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        int maxHeight = 0; // 건물 최대 높이
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(map[i][j], maxHeight);
            }
        }

        //2. while 반복문에서 비의 양을 0~ 건물 최대 높이 -1까지 돌리면서 영역 찾기
        int max = 0;
        for (int h = 0; h < maxHeight; h++) {
            visited = new boolean[n][n];

            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && map[j][k] > h) { //안전 영역
                        //cnt += bfs(j, k, h); // x, y, height
                        cnt += dfs(j, k, h); // x = j, y = k로 해당 부분부터 연결된 안전영역을 찾아 방문 처리하고 1을 반환한다.
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    //3. 안전 영역 찾기 - DFS => 212ms
    public static int dfs(int x, int y, int h) {
        visited[x][y] = true; //방문처리
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if (nX < 0 || nY < 0 || nX >= n || nY >= n) continue; //배열 범위 밖이면 아무 처리해주지 않는다.
            if (!visited[nX][nY] && map[nX][nY] > h) { // 안전 영역 방문 처리
                dfs(nX, nY, h);
            }
        }
        return 1;
    }

    //3. 안전 영역 찾기 - BFS => 248ms
//    public static int bfs(int x, int y, int h) {
//        Queue<int[]> queue = new LinkedList<>();
//        //boolean visited[][] = new boolean[n][];
//        queue.offer(new int[] {x, y});
//        visited[x][y] = true;
//
//        while (!queue.isEmpty()) {
//            int[] current = queue.poll();
//            int cX = current[0];
//            int cY = current[1];
//
//            for (int i = 0; i < 4; i++) { //상, 하, 좌, 우
//                int nX = current[0] + dx[i];
//                int nY = current[1] + dy[i];
//
//                if(nX < 0 || nY < 0 || nX >= n || nY >= n) continue; //배열 범위 밖이면 아무 처리해주지 않는다.
//                if(!visited[nX][nY] && map[nX][nY] > h){ // 안전 영역 방문 처리
//                    visited[nX][nY] = true;
//                    queue.add(new int[] {nX, nY});
//                }
//            }
//        }
//        return 1; //이어지는 곳을 한 영역으로 계산하기 때문에 1 반환.
//    }
}
