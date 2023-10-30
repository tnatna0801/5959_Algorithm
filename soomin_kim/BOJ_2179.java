import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2179 {

    static int check(String word1, String word2) {
        int cnt = 0, size = Math.min(word1.length(), word2.length());
        for(int i=0;i<size;i++) {
            if(word1.charAt(i)==word2.charAt(i)) cnt++;
            else break;
        }
        return cnt;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 입력
        String[] list = new String[N];
        for(int i=0; i<N; i++) {
            list[i] = br.readLine();
        }

        // 초기화
        int answer1=-1;
        int answer2=-1;
        int max=Integer.MIN_VALUE;

        // 반복문을 돌면서 문자끼리 비교
        for(int i=0; i<N-1; i++) {
            String word1 = list[i];

            // 다음 문자와 비교
            for(int j=i+1; j<N; j++) {
                int cnt = 0;
                String word2 = list[j];

                cnt = check(word1,word2);

                // 최대 길이 갱신
                if(cnt > max) {
                    answer1 = i;
                    answer2 = j;
                    max = cnt;
                }
            }
        }

        System.out.println(list[answer1]);
        System.out.println(list[answer2]);
    }
}