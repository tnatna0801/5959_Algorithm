import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        int left = 0; // IOI패턴의 시작
        int right = 0; // IOI패턴의 끝
        int result = 0; // 정답
        boolean flag = false; // 패턴 문자열의 시작 유무

        for(int i=0; i<m; i++) {
            if (!flag) {
                if (s[i] == 'O')
                    continue; // 패턴 문자열은 O부터 시작할 수 없음
                else {
                    // 현재 문자가 I라면 패턴 문자열의 시작
                    left = i;
                    flag = true;
                    continue;
                }
            }

            if (i+1<m && s[i] == 'O' && s[i+1] == 'I') {
                right = i+1; // 패턴 문자열의 끝을 표시
                i++; // i+1까지 봤으므로 i++.
            }
            else {
                int num = (right-left+1)/2 - n + 1; // 패턴 문자열의 0 개수
                if (num > 0) result += num; // 패턴 문자열을 만들 수 있을 때 결과 값에 추가

                flag = false; // 이 패턴 문자열은 끝났기 때문에 다음 패턴 문자열을 검사
                i--; // 현재 문자부터 다시 패턴 검사 필요.
            }
        }

        // 맨 마지막 패턴 문자열은 for문에서 보지 못하고 나오므로, 따로 처리
        if (right == m-1) {
            int num = (right-left+1)/2 -n +1;
            if (num>0) result+=num;
        }

        System.out.println(result);
    }
}