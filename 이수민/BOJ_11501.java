import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] days = new int[n];
            for(int i=0; i<n; i++) days[i] = Integer.parseInt(st.nextToken());


            int max=0; // 뒤에서 부터 주가의 최댓값이 저장됨
            long profit=0; // 만들 수 있는 최대 이익

            // 주가를 뒤에서 부터 차례대로 순회
            for(int i=n-1; i>=0; i--) {
                if (max < days[i]) { // 오늘의 주가가 이제까지 최댓값보다 크다면 갱신
                    max = days[i];
                }
                else {
                    // 오늘의 주가가 최댓값보다 작거나 같으면, 현재 이익에 더해줌
                    profit += max-days[i];
                }
            }
            sb.append(profit).append("\n");
        }
        System.out.println(sb);
    }
}
