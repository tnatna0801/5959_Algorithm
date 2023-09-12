import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25186 {
    static int N; // 옷 종류의 수
    static int[] clothes; // 종류별 옷 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        clothes = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            clothes[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        for(int i=0; i<N; i++) {
            sum += clothes[i]; // 종류별 옷 개수의 합
        }
        for(int i=0; i<N; i++) {
            // 혼자인 경우 옷이 겹칠 수 없으므로 옷의 총 개수가 1보다 크면서
            // 총 개수의 절반이 넘는 옷이 있다면
            if(sum > 1 && clothes[i] > sum/2) {
                System.out.println("Unhappy"); // 행복할 수 없다 출력하고
                return; // 바로 종료
            }
        }
        System.out.println("Happy"); // 모든 옷의 개수가 총합의 절반을 넘지 않는 경우
    }
}
