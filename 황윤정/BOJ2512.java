import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {
    static int N, M, result; // 지방의 수, 예산 총액, 예산 상한액의 최댓값
    static int max=Integer.MIN_VALUE; // 예산 요청 금액 중 최댓값
    static int[] arr; // 지방의 예산 요청

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int sum=0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(arr[i], max);
        }
        M = Integer.parseInt(br.readLine());
        if(sum <= M) { // 모든 요청이 배정될 수 있는 경우
            System.out.println(max); // 배정된 예산 중 최댓값 출력
        }
        else { // 배정될 수 없다면
            binarySearch(); // 예산의 상한액 정하기
            System.out.println(result); // 상한액 최댓값 출력
        }
    }

    static void binarySearch() {
        int mid;
        int low = 1; // 탐색범위 초기 최솟값
        int high = max; // 탐색범위 초기 최댓값: 요청받은 예산 중 최댓값
        int sum;
        while(low <= high) {
            mid = (low+high) / 2;
            sum = 0;
            for(int i=0; i<N; i++) {
                if(arr[i] < mid) { // 예산 상한액보다 작은 경우
                    sum += arr[i]; // 요청 금액 그대로
                }
                else {
                    sum += mid; // 요청 대신 상한액 배정
                }
            }
            if(sum <= M) { // 예산 배정이 가능한 경우
                result = Math.max(result, mid); // 예산 최댓값 찾기
                low = mid+1; // 더 큰 수로 예산 찾기
            }
            else {
                high = mid-1; // 더 작은 수로 예산 찾기
            }
        }
    }
}
