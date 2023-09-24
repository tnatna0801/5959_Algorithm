import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819 {
    static int[] a, cur;
    static int n;
    static boolean[] visited;
    static int max;

    static void permutation(int cnt){
        // 순열로 전체를 순회하면서 계산
        if (cnt == n){
            int sum = 0;
            for(int i=0; i<n-1; i++){
                sum += Math.abs(cur[i]-cur[i+1]);
            }
            max = Math.max(sum, max);
            return;
        }

        // 순열로 숫자의 순서를 정하여 배열에 넣는다.
        for(int i=0; i<n; i++){
            if (visited[i]) continue;

            cur[cnt] = a[i];
            visited[i] = true;
            permutation(cnt+1);
            visited[i] = false;

        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n];
        cur = new int[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        permutation(0);

        System.out.println(max);
    }
}
