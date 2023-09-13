import java.io.*;
import java.util.*;

public class boj1080 {

    static int n, m;
    static int[][] a;
    static int[][] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 행렬의 크기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 행렬 A
        a = new int[n][m];
        for (int i=0; i<n; i++) {
            String[] s = br.readLine().split("");
            for (int j=0; j<m; j++) {
                a[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 행렬 B
        b = new int[n][m];
        for (int i=0; i<n; i++) {
            String[] s = br.readLine().split("");
            for (int j=0; j<m; j++) {
                b[i][j] = Integer.parseInt(s[j]);
            }
        }

        // 연산의 횟수
        int cnt = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                // 행렬 A와 B의 값이 다르면 연산 시도
                if (a[i][j] != b[i][j]) {
                    // 3x3 크기의 부분 행렬을 만들 수 없는 경우 통과
                    if (!isPossible(i, j)) {
                        continue;
                    }
                    // 행렬 변환
                    change(i, j);
                    // 연산 횟수 증가
                    cnt++;
                }
            }
        }

        // 행렬 A, B 비교해서 같으면 정답, 다르면 -1 출력
        if (Arrays.deepEquals(a, b)) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }

    // 3x3 부분행렬을 만들 수 있는지 검사
    static boolean isPossible(int x, int y) {
        if (x+2 >= n || y+2 >= m) {
            return false;
        }
        return true;
    }

    // 행렬 변환
    static void change(int x, int y) {
        for (int i=x; i<x+3; i++) {
            for (int j=y; j<y+3; j++) {
                if (a[i][j] == 1) {
                    a[i][j] = 0;
                } else {
                    a[i][j] = 1;
                }
            }
        }
    }
}
