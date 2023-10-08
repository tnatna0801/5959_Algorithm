import java.io.*;
import java.util.*;

public class boj15729 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] button = new int[n]; // 초기 버튼 상태
        int[] goal = new int[n]; // 쪽지에 적힌 버튼 상태

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
            button[i] = 0;
        }

        int answer = 0;
        for (int i=0; i<n; i++) {
            // 버튼 상태가 다르면 버튼을 누른다.
            if (button[i] != goal[i]) {
                // 오른쪽 두 개의 버튼도 같이 눌린다.
                for (int j=i; j<i+3; j++) {
                    // 범위 초과하면 종료
                    if (j >= n) {
                        break;
                    }
                    button[j] = 1 - button[j];
                }
                // 버튼 누른 횟수 증가
                answer++;
            }
        }

        System.out.println(answer);
    }
}
