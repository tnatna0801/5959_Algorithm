import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16113 {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int len = Integer.parseInt(br.readLine());
        String signal = br.readLine();

        board = new char[5][len/5];

        // 5개로 쪼개기
        for(int i = 0; i<5; i++){
            board[i] = signal.substring(i*len/5 , (i+1)*len/5).toCharArray();
        }

        // 맨 위에 줄만 검사
        int idx = 0;
        while(true){

            if(idx >= len/5) break;

            if(board[0][idx] == '#'){
                // ### 일때, 의심할 수 있는 숫자 후보 => 0,2,3,5,6,7,8,9
                if(idx + 2 < len/5) {
                    if (board[0][idx + 1] == '#' && board[0][idx + 2] == '#') {
                        sb.append(find(idx));
                        idx += 3;
                        continue;
                    }
                }

                // 1 또는 4
                if(board[3][idx] =='#') {// 이러면 1임
                        sb.append(1);
                        idx++;
                }
                else { // 여긴 4!
                    sb.append(4);
                    idx += 3;
                }
            }
            else{
                idx++;
            }
        }
        System.out.println(sb);

    }
    public static int find(int start){
        int num = 0;

        // 비교를 위해서 뚝딱뚝딲 만들기
        String tmp = "";
        for(int i = 0; i<5; i++){
            for (int j = 0; j<3; j++){
                tmp += board[i][j+start];
            }
        }

        String[] number = new String[10]; // 0~9까지 시그널 만들기

        number[0] = "####.##.##.####";
        number[2] = "###..#####..###";
        number[3] = "###..####..####";
        number[5] = "####..###..####";
        number[6] = "####..####.####";
        number[7] = "###..#..#..#..#";
        number[8] = "####.#####.####";
        number[9] = "####.####..####";

        for(int i = 0; i<10; i++){
            if(tmp.equals(number[i])) {
                num = i;
                break;
            }
        }
        return num;
    }
}
