import java.io.*;
import java.util.*;

public class BOJ6236 {
    static int N, M;
    static int low = Integer.MIN_VALUE, high; // 이분탐색 처음, 마지막 범위
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            low = Math.max(low, arr[i]); // 이분탐색 처음은 입력값 중 최댓값
            high += arr[i]; // 마지막은 입력받은 금액들의 합
        }

        int mid = 0;
        while(low <= high) {
            mid = (low+high) / 2;
            int money = mid;
            int cnt=1; // 인출 횟수

            for(int i=0; i<N; i++) {
                if(arr[i] > money) { // 남은 금액보다 필요한 금액이 많다면
                    money = mid; // 인출해주고
                    cnt++; // 인출횟수 증가
                }
                money -= arr[i];
            }
            if(cnt > M) { // 인출횟수가 M보다 크다면
                low = mid+1; // 인출금액 늘리기
            }
            else { // 인출횟수가 M보다 작거나 같다면
                high = mid-1; // 인출금액 줄이기
            }
        }
        System.out.println(mid);
    }
}
