import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15729 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 쪽지에 적힌 N자리 수
        int[] goal = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            goal[i] = Integer.parseInt(st.nextToken());
        }

        int[] btn = new int[N]; // 버튼 상태
        int cnt = 0; // 버튼 누른 수
        for(int i=0; i<N; i++){
            if (goal[i] != btn[i]){
                ++cnt;

                // 현재 버튼과 오른쪽 두개 버튼 바꾸기
                btn[i] = goal[i];
                if (i+1<N)
                    btn[i+1] = btn[i+1] == 0 ? 1 : 0;
                if (i+2 < N)
                    btn[i+2] = btn[i+2] == 0 ? 1 : 0;
            }
        }

        System.out.println(cnt);

    }
}
