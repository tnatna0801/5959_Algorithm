import java.io.*;
import java.util.StringTokenizer;

public class BOJ_S11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++){

            //입력 및 초기화
            int n = Integer.parseInt(br.readLine());
            long[] days = new long[n]; // 날 별 주가를 나타내는 배열
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<n; i++){
                days[i] = Long.parseLong(st.nextToken());
            }

            // 날의 수 만큼 반복문 돌기
            // 역방향으로 돌면서 최대 이익 구하기 => 그리디 인가? 완전 탐색인가?
            long sum = 0;
            long target = days[n-1]; // 팔 값
            for(int i = n-2; i>=0; i--){
                // 더 큰 값이 나오면 현재 값을 더 큰 값으로 갱신한다.
                if(target < days[i]) {
                    target = days[i];
                    continue;
                }
                // 현재 값보다 더 큰 값이 있을 때까지 현재 값으로 이익을 계산한다.
                sum += (target - days[i]);

            }
            //출력
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
