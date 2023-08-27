import java.io.*;
import java.util.*;

public class boj6236 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] amount = new int[n];
        for (int i=0; i<n; i++) {
            amount[i] = Integer.parseInt(br.readLine());
        }

        int start = 1; // 이용할 금액의 최솟값
        int end = 10000 * 100000; // 이용할 금액의 최댓값

        while (start <= end) {
            int mid = (start + end) / 2; // 인출 금액
            int balance = 0; // 잔액
            int cnt = 0; // 인출 횟수

            for (int a: amount) {
                // 그날 사용할 금액이 인출할 금액보다 클 경우 범위 늘리기
                if (a > mid) {
                    cnt = 100000;
                    break;
                }

                if (balance < a) { // 돈이 모자란 경우
                    // 잔액 = 인출한 금액 - 그날 사용할 금액
                    balance = mid - a;
                    // 인출 횟수 증가
                    cnt++;
                } else { // 돈이 모자라지 않을 경우
                    // 잔액 = 잔액 - 그날 사용할 금액
                    balance -= a;
                }
            }

            if (cnt <= m) { // 인출 횟수 <= m인 경우 범위 줄이기 (인출 금액이 클 수록 인출 횟수가 줄어든다.)
                end = mid - 1;
            } else { // 인출 횟수 > m인 경우 범위 늘리기
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
