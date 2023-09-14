import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16401 {
    static int N, M, result; // 과자의 수, 조카의 수, 과자 최대길이
    static int[] arr; // 과자들 길이 저장
    static int low, high, mid; // 이분탐색 범위 최소, 최대, 중간값
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]); // 가장 긴 과자의 길이가 이분탐색 범위 최댓값
        }

        low = 1;
        while(low <= high) {
            long sum = 0;
            mid = (low+high) / 2; // 나누려는 과자의 길이
            for(int i=0; i<N; i++) {
                long cnt = arr[i] / mid; // mid만큼 과자를 나눌 수 있는 갯수
                sum += cnt;
            }
            if(sum >= M) { // 줄 수 있는 과자가 조카의 수 이상
                low = mid+1; // 나누는 과자 길이 증가
                result = Math.max(result, mid); // 과자 길이 최댓값 저장
            }
            else { // 줄 수 있는 과자가 조카의 수보다 모자라면
                high = mid-1; // 나누는 과자 길이 감소
            }
        }
        System.out.println(result); // 줄 수 있는 과자의 최대 길이
    }
}
