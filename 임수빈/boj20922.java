import java.io.*;
import java.util.*;

public class boj20922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] visited = new int[100001]; // 방문 체크
        int j = 0;
        int answer = 0, cnt = 0;

        // 앞 포인터
        for (int i=0; i<n; i++) {
            // 뒤 포인터
            while (j < n && visited[a[j]] < k) {
                visited[a[j++]]++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
            cnt--;
            visited[a[i]]--;
        }

        System.out.println(answer);
    }
}
