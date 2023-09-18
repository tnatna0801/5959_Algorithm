import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ16113 {
    static int N;
    static boolean[][] signal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        // N/5해서 배열의 가로 길이 정하기(세로는 무조건 5)
        signal = new boolean[5][N/5];
        // 입력받은 시그널 정보를 boolean 배열에 채우기(#이면 true, .이면 false)
        decryption(input);

        for(int i=0; i<N/5; i++) {
            if(!signal[0][i])
                continue; // 공백 열 패스

            // 현재 열이 모두 색칠되어있는가 (1 찾기 위한 사전 작업)
            boolean isOne=true;
            for(int j=0; j<5; j++) {
                if(!signal[j][i]) {
                    isOne = false;
                    break;
                }
            }
            if(isOne && (i+1 >= N/5 || !signal[0][i+1])) {
                // 1인 경우 : 현재 열이 모두 #이면서, 마지막 열에 위치하거나 옆이 빈 열인 경우
                sb.append(1);
                i++;
                continue;
            }
            // 1이 아닌 경우
            int num = findNum(i); // 1 제외한 0~9찾기
            i += 3;
            sb.append(num);
        }
        System.out.println(sb.toString());
    }

    static int findNum(int c) {
        // 현재 열에서 #이 칠해진 개수를 세어 숫자를 1차 선별
        // 숫자 간에 .인지 #인지 비교하여 숫자 최종 선별
        
        int cnt=0; // 현재 열에서 #의 개수
        for(int r=0; r<5; r++) {
            if(signal[r][c]) {
                cnt++;
            }
        }
        if(cnt == 1) { // # 개수 1개
            return 7;
        }
        else if(cnt == 3) { // # 개수 3개
            if(signal[1][c]) {
                return 4;
            }
            else {
                return 3;
            }
        }
        else if(cnt == 4) { // # 개수 4개
            if(!signal[1][c]) {
                return 2;
            }
            else if(!signal[1][c+2]) {
                return 5;
            }
            else {
                return 9;
            }
        }
        else { // # 개수 5개
            if(!signal[2][c+1]) {
                return 0;
            }
            else if(!signal[1][c+2]) {
                return 6;
            }
            else {
                return 8;
            }
        }
    }

    // 시그널을 디지털 숫자로 만들기
    static void decryption(String input) {
        int idx=0;
        char tmp;
        for(int i=0; i<5; i++) {
            for(int j=0; j<N/5; j++) {
                tmp = input.charAt(idx++);
                if(tmp == '#') {
                    signal[i][j] = true;
                }
                else {
                    signal[i][j] = false;
                }
            }
        }
    }
}
