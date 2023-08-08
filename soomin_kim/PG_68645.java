import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 삼각 달팽이
public class PG_68645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = solution(n);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];

        int x = -1;
        int y = 0;

        //삼각형 만들기
        int count = 1;
        int[][] snail = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) { // 한 면씩 지나갈 때마다 1씩 감소한다.
                if (i % 3 == 0) // 세로
                    ++x;
                else if (i % 3 == 1) { // 가로
                    ++y;
                } else if (i % 3 == 2) { // 대각선
                    --x;
                    --y;
                }
                snail[x][y] = count++;
            }
        }
        // answer 배열에 넣기
        int index = 0;
        for(int i = 0; i<snail.length; i++){
            for(int j = 0; j<=i; j++){
                answer[index] = snail[i][j];
                index++;
            }
        }
        return answer;
    }
}