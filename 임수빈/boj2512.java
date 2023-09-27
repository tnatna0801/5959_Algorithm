import java.io.*;
import java.util.*;

public class boj2512 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 지방의 수
        int[] budget = new int[n]; // 각 지방의 예산 요청

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budget);

        int m = Integer.parseInt(br.readLine()); // 국가 예산의 총액

        int start = 1;
        int end = budget[n-1];

        // 이분탐색
        while (start <= end) {
            // 정수 상한액
            int mid = (start + end) / 2;

            // 총 예산
            int total = 0;
            for (int i=0; i<n; i++) {
                // 정수 상한액 배정
                if (budget[i] >= mid) {
                    total += mid * (n - i);
                    break;
                }
                // 요청 금액 그대로 배정
                total += budget[i];
            }

            // 국가 예산의 총액보다 큰 경우 예산을 줄인다.
            if (total > m) {
                end = mid - 1;
            }
            // 국가 예산의 총액보다 작을 경우 예산을 늘린다.
            else {
                start = mid + 1;
            }
        }

        // 배정된 예산들 중 최댓값
        System.out.println(end);
    }
}
