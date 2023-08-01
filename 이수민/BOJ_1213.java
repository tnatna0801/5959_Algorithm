import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray(); // 원래 문자열
        int arrLen = str.length; // 문자열의 길이
        char[] result = new char[arrLen]; // 결과 팰린드롬 문자열
        int[] alphabet = new int[26]; // 알파벳 저장

        for (char c:str){ // 원래 문자열에서 등장하는 알파벳 수 저장
            alphabet[c-'A'] += 1;
        }

        int idx = 0; // 문자열의 어디를 채울지 정하는 인덱스
        for(int i=0; i<26; i++){

            if (alphabet[i] == 0) // 쓰이지 않은 알파벳이면 과정 생략
                continue;

            if (alphabet[i]%2!=0){
                // 현재 알파벳의 개수가 홀수인데, 이미 중간값이 있을 때 -> 팰린드롬 안됨
                if (result[arrLen/2] != 0) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                } else { // 홀수 + 아직 중간값이 없는 경우 -> 현재 알파벳을 중간값으로
                    // 현재 알파벳을 하나 사용하여 결과 배열에 넣음
                    alphabet[i] -= 1;
                    result[arrLen/2] = (char)(i+'A');
                }
            }

            while(alphabet[i] > 0){ // 사용할 수 있는 알파벳 수가 남은 동안
                // 지금 위치들에 현재 알파벳을 넣는다.
                result[idx] = (char)(i+'A');
                result[arrLen-idx-1] = (char)(i+'A');
                alphabet[i] -= 2; // 두개 사용했으므로 -2.
                idx += 1; // 위치 갱신
            }
        }

        Arrays.asList(result).forEach(c -> System.out.print(c));

    }
}
