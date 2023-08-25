import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int N;
    static int[][] map;
    static long[][] result;

    public static void dp(int x, int y) {

        int v = map[x][y]; // 현재 맵에서 점프할 수 있는 거리
        if (v == 0) return; // 이동할 수 없다면 생략

        if (x+v < N) { // 아래로 점프할 수 있다면
            result[x+v][y] += result[x][y]; // 현재 위치까지 오는 경우의 수를 점프할 위치에 더해준다.
        }

        if (y+v < N) { // 오른쪽으로 점프할 수 있다면
            result[x][y+v] += result[x][y]; // 현재 위치까지 오는 경우의 수를 점프할 위치에 더해준다.
        }

    }
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = new long[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result[0][0] = 1; // 0, 0에 도달할 수 있는 경우의 수는 1로 지정.

        // 맵을 순회하면서 해당 영역에 도착할 수 있는 경우의 수를 저장해준다.
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                dp(i, j);
            }
        }

        System.out.println(result[N-1][N-1]);

    }
}
