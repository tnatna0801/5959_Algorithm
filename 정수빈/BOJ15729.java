import java.util.*;
import java.io.*;

public class BOJ15729 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int[] buttons = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            buttons[i] = Integer.parseInt(st.nextToken());

        // 모든 버튼을 0으로 만드는 최소 수를 찾는다
        for(int i=0; i<N; i++) {
            if(buttons[i] == 0) continue;

            // 1일 경우에는 그로부터 오른쪽 세 칸을 바꾼다
            for(int move=0; move<3; move++) {
                if(move+i>=N) continue;

                buttons[move+i] = (buttons[move+i]-1)*(-1);
            }
            count += 1;
        }
        System.out.println(count);
    }
}
