import java.io.*;
import java.util.*;

public class BOJ {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            long[] days = new long[N];

            for(int i=0; i<N; i++)
                days[i] = Integer.parseInt(st.nextToken());

            long money = 0; // 수익
            long max = days[N-1];

            // 배열 역순으로 탐색한다
            for(int i=N-1; i>=0; i--)
                // 더 큰 수를 만나기 전까지는 현재 max로 되팔기를 진행한다
                // 더 크거나 같은 수를 만나면 max 값을 갱신한다
                if(max <= days[i])
                    max = days[i];
                else
                    money += (max-days[i]);

            System.out.println(money);
        }
    }
}
