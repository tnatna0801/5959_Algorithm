import java.io.*;
import java.util.*;

public class boj5397 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        // 강산이가 입력한 문자열을 저장할 배열
        char[] input;
        // 강산이의 비밀번호를 저장할 배열
        LinkedList<Character> answer;
        // 커서의 위치
        int idx;

        for (int t=0; t<T; t++) {
            input = br.readLine().toCharArray();
            answer = new LinkedList<>();
            idx = 0;

            for (char i: input) {
                // 커서 왼쪽으로 옮기기
                if (i == '<') {
                    idx = (idx == 0)? idx : idx-1;
                    continue;
                }

                // 커서 오른쪽으로 옮기기
                if (i == '>') {
                    idx = (idx == answer.size())? idx : idx+1;
                    continue;
                }

                // 글자 삭제
                if (i == '-') {
                    if (idx == 0) {
                        continue;
                    }
                    answer.remove(--idx);
                    continue;
                }

                // 글자 삽입
                answer.add(idx++, i);
            }

            for (char a: answer) {
                sb.append(a);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
