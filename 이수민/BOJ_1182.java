import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {

    static int cnt = 0;
    static int s;
    static int n;
    static int[] nums;

    // 합/몇번째 인덱스인지
    static void dfs(int sum, int i){

        if (i >= n){
            return;
        }

        if (sum+nums[i] == s){
            cnt++;
        }

        dfs(sum+nums[i], i+1); // 현재 수를 넣는 경우
        dfs(sum, i+1); // 안넣는 경우

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(cnt);
    }
}
