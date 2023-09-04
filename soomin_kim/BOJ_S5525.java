import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 비트 연산자를 사용해야할 것 같습니당나귀

        //입력
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        //String[] s = br.readLine().split("");

        int idx = 0;
        int count = 0; // Pn만 확인 하기 위해서 만든 count 변수
        int answer = 0; // Pn이 몇 군데 포함되어 있는지 출력하는 변수
        while(true) {
            if(idx > m-3){ // 입력받은 s를 넘어가면 break
                break;
            }

            if(s.substring(idx, idx+3).equals("IOI")){ // P1이 있다면 이어서 확인
                idx += 2; // IO * (n-1) + IOI 이라서
                count++; // IOI가 존재하므로 count+ 증가
                if(count == n){ // 만약에 Pn을 검사했다면... Pn의 갯수를 늘려주고 다시 count를 -한다. 그니까 IOIOIOIO 이캐 증식시키지 않기 위해서 필요한 변수임
                    answer++;
                    count--; // count -1함 왜냐면 이제 방금 탐색한 곳 부터 시작해서 또다른 Pn이 만들어질 가능성을 고려해야한다!!!
                }
            }
            else { // P1이 없다면 Pn 문자열이 될 수 없으므로 다음 인덱스로 넘어가서 탐색한다.
                idx++;
                count = 0; // 초기화
            }
        }
        System.out.println(answer);
    }
}
