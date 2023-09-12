import java.io.*;
import java.util.*;

public class boj16401 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 조카의 수
        int n = Integer.parseInt(st.nextToken()); // 과자의 수

        st = new StringTokenizer(br.readLine());

        int[] l = new int[n];
        for (int i=0; i<n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(l);

        int start = 1;
        int end = l[n-1];

        // 이분 탐색
        while (start <= end) {
            // 조카 1명에게 줄 막대 과자의 길이
            int mid = (start + end) / 2;

            // 몇 명에게 과자를 줄 수 있는지 세기
            int cnt = 0;
            for (int i: l) {
                cnt += i / mid;
            }

            // m명보다 많거나 같은 사람에게 줄 수 있다면 과자 길이 늘리기
            if (cnt >= m) {
                start = mid + 1;
            }
            // m명보다 적은 사람에게 줄 수 있다면 과자 길이 줄이기
            else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
