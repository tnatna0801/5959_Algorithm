import java.io.*;
import java.util.*;

public class boj5397_ListIterator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            // 문자열 입력
            char[] input = br.readLine().toCharArray();

            // 정답 리스트
            LinkedList<Character> answer = new LinkedList<>();
            ListIterator<Character> iter = answer.listIterator();

            for (char i: input) {
                // 커서를 왼쪽으로 이동
                if (i == '<') {
                    if (!iter.hasPrevious()) {
                        continue;
                    }
                    iter.previous();
                    continue;
                }

                // 커서를 오른쪽으로 이동
                if (i == '>') {
                    if (!iter.hasNext()) {
                        continue;
                    }
                    iter.next();
                    continue;
                }

                // 문자 지우기
                if (i == '-') {
                    if (!iter.hasPrevious()) {
                        continue;
                    }
                    iter.previous();
                    iter.remove();
                    continue;
                }

                // 문자 삽입
                iter.add(i);
            }

            // 정답
            for (char a: answer) {
                sb.append(a);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
