import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {
    static int N, result=Integer.MIN_VALUE; // 입력값 개수, 결과 저장
    static int[] arr, nums; // 입력값, 순서를 바꾼 배열
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        nums = new int[N];
        visited = new boolean[N];
        getOrder(0);
        System.out.println(result);
    }

    // 배열에 있는 정수의 순서 바꾸기
    public static void getOrder(int cnt) {
        if(cnt == N) {
            result = Math.max(result, calc()); // 최댓값 저장
            return;
        }
        for(int i=0; i<N; i++) {
            if(!visited[i]) { // 아직 뽑지 않은 수라면
                visited[i] = true;
                nums[cnt] = arr[i]; // 순서 바꾸는 배열에 저장하고
                getOrder(cnt+1); // 다음 자리 수 뽑기
                visited[i] = false;
            }
        }
    }

    // 문제에서 요구하는 식 계산
    public static int calc() {
        int sum=0;
        for(int i=0; i<N-1; i++) {
            sum += Math.abs(nums[i] - nums[i+1]);
        }
        return sum;
    }
}
