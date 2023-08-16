import java.io.*;
import java.util.*;

public class boj5397_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            // 문자열 입력
            char[] input = br.readLine().toCharArray();

            // 현재 커서의 왼쪽 문자열을 저장할 스택
            Stack<Character> left = new Stack<>();
            // 현재 커서의 오른쪽 문자열을 저장할 스택
            Stack<Character> right = new Stack<>();

            for (char i: input) {
                // 커서를 왼쪽으로 이동
                if (i == '<') {
                    if (left.isEmpty()) {
                        continue;
                    }
                    right.add(left.pop());
                    continue;
                }

                // 커서를 오른쪽으로 이동
                if (i == '>') {
                    if (right.isEmpty()) {
                        continue;
                    }
                    left.add(right.pop());
                    continue;
                }

                // 문자 지우기
                if (i == '-') {
                    if (left.isEmpty()) {
                        continue;
                    }
                    left.pop();
                    continue;
                }

                // 문자 삽입
                left.add(i);
            }

            StringBuilder sb = new StringBuilder();

            // 오른쪽 문자열 모두 왼쪽 문자열로 옮긴 후
            while (!right.isEmpty()) {
                left.add(right.pop());
            }

            // 왼쪽 문자열을 모두 꺼낸다.
            while (!left.isEmpty()) {
                sb.append(left.pop());
            }

            // 정답 출력
            sb.reverse();
            System.out.println(sb);
        }
    }
}
