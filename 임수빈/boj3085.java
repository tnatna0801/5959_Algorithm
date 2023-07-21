import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj3085 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력

        int answer = 0;

        // 보드의 크기
        int n = Integer.parseInt(br.readLine());

        // 보드에 채워져 있는 사탕의 색상
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            board[i] = s.toCharArray();
        }

        for (int i=0; i<n; i++) {
            for (int j=1; j<n; j++) {
                // 왼쪽 비교
                if (board[i][j-1] != board[i][j]) {
                    // 값 교환
                    char tmp1 = board[i][j-1];
                    char tmp2 = board[i][j];

                    board[i][j-1] = tmp2;
                    board[i][j] = tmp1;

                    // 최댓값 갱신
                    answer = Math.max(answer, getCnt(n, board));

                    // 값 되돌리기
                    board[i][j-1] = tmp1;
                    board[i][j] = tmp2;
                }

                // 위쪽 비교
                if (board[j-1][i] != board[j][i]) {
                    // 값 교환
                    char tmp1 = board[j-1][i];
                    char tmp2 = board[j][i];

                    board[j-1][i] = tmp2;
                    board[j][i] = tmp1;

                    // 최댓값 갱신
                    answer = Math.max(answer, getCnt(n, board));

                    // 값 되돌리기
                    board[j-1][i] = tmp1;
                    board[j][i] = tmp2;
                }
            }
        }

        // 정답 출력
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }


    public static int getCnt(int n, char[][] board) {
        int maxCnt = 0;
        int cnt;

        // 가장 긴 연속하는 부분 찾기
        for (int i=0; i<n; i++) {
            // 행 순회
            cnt = 1;
            for (int j=1; j<n; j++) {
                if (board[i][j] == board[i][j-1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }

            // 열 순회
            cnt = 1;
            for (int j=1; j<n; j++) {
                if (board[j][i] == board[j-1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }
        }

        return maxCnt;
    }

}