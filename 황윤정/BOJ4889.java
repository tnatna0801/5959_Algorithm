import java.io.*;

public class BOJ4889 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc=1; // 테스트 케이스 번호
        while(true) {
            char[] input = br.readLine().toCharArray();
            if(input[0] == '-') { // 마지막 줄일 때 반복문 탈출하고 결과 출력
                break;
            }
            int left=0; // '{' 개수
            int result=0; // 괄호 바꾼 횟수
            for(int i=0; i<input.length; i++) {
                if(input[i] == '{') { // 왼쪽 중괄호 입력받으면
                    left++; // 왼쪽 중괄호 개수 증가
                }
                else { // 오른쪽 중괄호 입력받으면
                    if(left > 0) { // 입력받은 왼쪽 중괄호가 남아있다면
                        left--; // {} 쌍이 만들어졌으므로 왼쪽 중괄호 개수 감소
                    }
                    else {
                        result++; // }를 {로 바꿔야하므로 연산 횟수 증가
                        left++;
                    }
                }
            }
            if(left > 0) { // 모든 입력값을 처리하고 왼쪽 중괄호 개수가 남았다면
                result += left/2; // 남은 개수의 절반을 오른쪽 괄호로 바꿔야하므로 연산 횟수 증가
            }
            sb.append(tc+". "+result+"\n"); // 해당 테스트 케이스 바꾸는 연산 횟수
            tc++;
        }
        System.out.println(sb.toString());
    }
}
