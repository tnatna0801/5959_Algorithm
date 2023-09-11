import java.io.*;

public class boj5525 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        // 문자열 Pn의 길이
        int size = 2 * n + 1;

        int answer = 0;
        int i = 0; // 탐색 인덱스
        int cnt; // 반복 개수
        boolean flag;

        while (i < m) {
            flag = false;

            // 비교 시작
            if (s[i] == 'I') {
                cnt = 1;

                for (int j = i + 1; j < m; j++) {
                    flag = true;

                    // O - I 반복 확인
                    if ((cnt % 2 == 1 && s[j] == 'O') || (cnt % 2 == 0 && s[j] == 'I')) {
                        cnt++;

                        // Pn 포함 개수 세기
                        if (cnt >= size && s[j] == 'I') {
                            answer++;
                        }

                        // 인덱스 끝까지 탐색했을 경우
                        if (j == m - 1) {
                            i = m;
                            break;
                        }

                        continue;
                    }

                    // 탐색 완료
                    i = j;
                    break;
                }
            }

            if (!flag) {
                i++;
            }
        }

        System.out.println(answer);
    }

}