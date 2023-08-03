import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        int[] alphabet = new int[26]; //A~Z == 65~90

        for(int i = 0; i<name.length(); i++){
            alphabet[name.charAt(i)-'A']++;
        }

        StringBuilder sb = new StringBuilder(); //

        int count = 0;
        for(int i = 0; i<alphabet.length; i++){
            if(alphabet[i] % 2 == 1){
                count++;
            }
        }

        String answer = ""; // 결과를 저장하는 변수
        if(count > 1){ // 홀수가 1개 이상이면 팰린드롬이 될 수 없다!!!
            System.out.println("I'm Sorry Hansoo");
        }
        else{
            // 앞쪽
            for(int i = 0; i<alphabet.length; i++){
                for(int j = 0; j<alphabet[i]/2; j++){ // 해당 알파벳의 절반 크기는 앞쪽에 위치한다.
                    sb.append((char)(i+65));
                }
            }

            answer += sb.toString();

            //가운데는 홀수개의 알파벳이 온다.
            StringBuilder sbMid = new StringBuilder();
            for(int i = 0; i<alphabet.length; i++){
                if(alphabet[i]%2==1){
                    sbMid.append((char)(i+65));
                }
            }
            answer += sbMid.toString();

            // 나머지 절반은 뒤쪽에 위치하는데 순서를 반대로 해서 stringbuilder에 저장한다.
            answer += sb.reverse().toString();
            System.out.println(answer);
        }
    }
}
