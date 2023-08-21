import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1303 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int n, m; // 가로크기 세로크기
    static int pos[], mx, my; // 임시 좌표들
    static char[][] map;
    static int[][] tmp; // 위력 정보를 넣을 배열
    static Queue<int[]> queue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int bfs(char team) {
        tmp = new int[m][n];
        queue = new ArrayDeque<>();
        int sum, result=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (tmp[i][j] == 0 && map[i][j] == team) { // 방문 안 한 요소, 아군일 때
                    queue.offer(new int[] {i, j}); // 큐에 넣고,
                    tmp[i][j] = 1; // 아군 표시
                    sum = tmp[i][j];
                    // 큐를 순회하면서 뭉쳐있는 아군의 수를 누적
                    while(!queue.isEmpty()) {
                        pos = queue.poll();
                        for(int k=0; k<4; k++) {
                            mx = pos[0] + dx[k];
                            my = pos[1] + dy[k];

                            // 전쟁터의 범위를 넘지 않고, 아직 방문하지 않은 아군일 때
                            if (mx >= 0 && mx<m && my>=0 && my<n && tmp[mx][my] == 0 && map[mx][my] == team) {
                                tmp[mx][my] = sum++;
                                queue.offer(new int[] {mx, my});
                            }
                        }
                    }
                    // N명이 뭉쳐있을 때의 N^2의 위력
                    result += Math.pow(sum, 2);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[m][n];
        // 전쟁터 입력
        for(int i=0; i<m; i++) {
            map[i] = br.readLine().toCharArray();
        }
        System.out.println(bfs('W') + " " + bfs('B'));
    }
}
