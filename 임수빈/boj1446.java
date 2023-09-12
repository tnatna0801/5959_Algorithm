import java.io.*;
import java.util.*;

class Path implements Comparable<Path> {
    int start;
    int end;
    int length;

    public Path(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    @Override
    public int compareTo(Path o) {
        // 1. 시작점 기준 오름차순 정렬
        int c = this.start - o.start;
        if (c == 0) {
            // 2. 도착점 기준 오름차순 정렬
            return this.end - o.end;
        }
        return c;
    }
}

public class boj1446 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<Path> paths = new ArrayList<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            // 도착점이 고속도로의 길이를 넘거나
            // 지름길의 길이가 도로의 길이보다 긴 경우
            // 지름길 목록에 추가하지 않는다.
            if (e > d || (e - s) < l) {
                continue;
            }

            paths.add(new Path(s, e, l));
        }

        Collections.sort(paths);

        int[] dp = new int[d+1];
        for (int i=1; i<d+1; i++) {
            dp[i] = i; // 초기화 (최댓값 = 도로의 길이)
        }

        int idx = 1;

        // 지름길을 순회하면서
        for (int i=0; i<paths.size(); i++) {
            Path path = paths.get(i);

            // 전 지름길의 도착점부터 현 지름길의 출발점까지의 최솟값 갱신
            for (int j=idx; j<=path.start; j++) {
                dp[j] = Math.min(j, dp[j-1] + 1);
            }

            // 현 지름길의 출발점부터 현 지름길의 도착점까지의 최솟값 갱신
            for (int j=path.start+1; j<=path.end; j++) {
                dp[j] = Math.min(dp[j-1] + 1, dp[j]);
            }

            // 도착점 최솟값 갱신
            dp[path.end] = Math.min(dp[path.end], dp[path.start] + path.length);

            // 도착점 인덱스
            idx = path.end+1;
        }

        // 지름길을 모두 돈 후 고속도로 끝까지 길이가 남은 경우
        if (paths.size() > 0) {
            for (int i = paths.get(paths.size() - 1).end + 1; i < d + 1; i++) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            }
        }

        System.out.println(dp[d]);
    }
}
