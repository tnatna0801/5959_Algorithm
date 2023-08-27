import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 비밀번호를 입력받을 횟수인 n을 입력받습니다.
        for(int i=0;i<n;i++) {
            String[] in = br.readLine().split("");
            StringBuilder sb = new StringBuilder();
            Stack<String> pwd = new Stack<>();  // 비밀번호만 저장될 스택
            Stack<String> temp = new Stack<>();  // 커서가 안쪽으로 이동함에 따라 pop되어 따로 저장시켜둘 스택
            for(int j=0;j<in.length;j++) {
                if(in[j].equals("<")) { // < 입력
                    if(!pwd.isEmpty()) { // 비밀번호 스택이 완전 비어서 이동할 커서가 없는 경우를 제외
                        temp.push(pwd.pop()); // 비밀번호 스택에서 팝을 한 값을 잠시 temp 스택에 저장해 둡니다.
                    }
                }
                else if(in[j].equals(">")) { // > 입력
                    if(!temp.isEmpty()) { // temp 스택이 완전히 비어서 더 이상 가져올 수 없는 경우를 제외
                        pwd.push(temp.pop()); // 임시 저장해둔 temp 값에서 값을 꺼내 비밀번호 스택에 다시 돌려 놓습니다.
                    }
                }
                else if(in[j].equals("-")) { // - 입력
                    if(!pwd.isEmpty()) // 비밀번호 스택이 완전 비어서 지울 값이 없을 경우룰 제외
                        pwd.pop(); // 비밀번호 스택에서 값을 빼서 지워줍니다.
                }
                else // 일반 비밀번호 입력
                    pwd.push(in[j]); // 비밀번호 스택에 값을 넣어줍니다.
            }
            while(!temp.isEmpty()) { // 입력에 따라 모든 작업이 끝낸 후, 아직 temp에 남은 값을 다시 꺼내 주어야합니다
                pwd.push(temp.pop()); // temp가 빌 때까지 temp 스택에 임시저장해둔 비밀번호를 비밀번호 스택에 넣어줍니다
            }
            while(!pwd.isEmpty()) { // 출력을 위해 비밀번호 스택이 빌 때까지 StringBuilder에 저장합니다.
                sb.append(pwd.pop());
            }
            sb.reverse(); // 스택은 거꾸로 저장되기 때문에 역으로 정렬합니다
            System.out.println(sb); // StringBuilder로 출력합니다.
        }
    }
}
