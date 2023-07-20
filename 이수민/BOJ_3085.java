import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085{

    public static int N;
    public static char[][] board;
    public static int max = 0;

    // 사탕 교환
    public static void exchangeCandies(int i, int j, int r, int c){
        char tmp = board[i][j];
        board[i][j] = board[i+r][j+c];
        board[i+r][j+c] = tmp;
        countMaxCandies();
        tmp = board[i][j];
        board[i][j] = board[i+r][j+c];
        board[i+r][j+c] = tmp;
    }

    // 최대 개수 구하기
    public static void countMaxCandies(){
        // 가로 방향
        for(int i=0; i<N; i++){
            int cnt = 1;
            for(int j=0; j<N-1; j++){
                if (board[i][j] == board[i][j+1]){
                    cnt++;
                    max = Math.max(max, cnt);
                }
                else{
                    cnt=1;
                }
            }
        }

        // 세로 방향
        for(int i=0; i<N; i++){
            int cnt = 1;
            for(int j=0; j<N-1; j++){
                if (board[j][i] == board[j+1][i]){
                    cnt++;
                    max = Math.max(max, cnt);
                }
                else{
                    cnt=1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        // board 채우기
        for(int i=0; i<N; i++){
            char[] s = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                board[i][j] = s[j];
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                // 가로 교환
                if (board[i][j] != board[i][j+1])
                    exchangeCandies(i, j, 0, 1);

                // 세로 교환
                if (board[j][i] != board[j+1][i])
                    exchangeCandies(j, i, 1, 0);
            }
        }

        System.out.println(max);

    }
}