import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static int N, P; // 음의 수, 프렛의 수
    static Stack[] stack = new Stack[7]; // 기타 줄 6개로 고정
    static int move; // 손가락의 움직임

    // 줄마다 프렛을 관리하는 스택을 이용하여 손가락의 움직임을 구함
    public static void putToStack(int string, int fret) {
        if (stack[string].isEmpty()) { 
            // 현재 줄에 대한 스택에 현재 아무것도 없다면, 프렛을 스택에 추가하고 움직임도 추가
            move += 1;
            stack[string].add(fret);
            return;
        }

        // 지금 줄에 대한 스택의 최근 프렛을 보기
        int peek = (int)stack[string].peek();
        
        if (peek < fret) { // 스택 안의 프렛이 지금 선택하려는 프렛보다 작으면, 그 위에 추가
            move += 1;
            stack[string].add(fret);

        }
        else if (peek > fret) { // 스택 안의 프렛이 지금 선택하려는 프렛보다 크다면, 아닐 때까지 빼내기
            while(!stack[string].isEmpty() && (int)stack[string].peek() > fret) {
                stack[string].pop();
                move += 1;
            }
            // 스택이 비어있지 않고, 스택 안의 프렛과 지금 프렛의 수가 같지 않다면 실행
            // 같은 경우에는 스택을 변화시키지 않아도 되어, 움직일 필요가 없다.
            if (stack[string].isEmpty() || (int)stack[string].peek() != fret) {
                move += 1;
                stack[string].add(fret);
            }
        }
    }
    public static void main(String[] args) throws Exception {

        for(int i=1; i<=6; i++) {
            stack[i] = new Stack<Integer>();
        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 줄 정보
            int p = Integer.parseInt(st.nextToken()); // 프렛 정보
            putToStack(s, p);

        }

        System.out.println(move);

    }
}
