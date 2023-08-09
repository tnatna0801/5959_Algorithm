import java.io.*;
import java.util.*;

public class boj11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] miro = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            miro[i] = Integer.parseInt(st.nextToken());
        }

        // dp 배열 초기화
        int[] dp = new int[n];
        for (int i=1; i<n; i++) {
            dp[i] = 1000;
        }

        int idx = 0; // 인덱스
        int x = miro[idx]; // idx번째 칸에 쓰여있는 수

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{idx, x});

        // bfs
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            idx = q[0];
            x = q[1];

            for (int i=idx+1; i<=idx+x; i++) {
                // 인덱스 범위를 벗어나면 종료
                if (i >= n) {
                    break;
                }

                // 이미 값이 존재하면 통과
                if (dp[i] != 1000) {
                    continue;
                }

                // 값 갱신 (점프)
                dp[i] = dp[idx] + 1;
                queue.add(new int[]{i, miro[i]});
            }
        }

        if (dp[n-1] == 1000) { // 값이 없는 경우
            System.out.println(-1);
        } else { // 값이 있는 경우
            System.out.println(dp[n-1]);
        }
    }
}
