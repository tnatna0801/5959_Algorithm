import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_4889 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int idx = 1;
        while(true){
            //st = new StringTokenizer(br.readLine());
            String[] tmp = br.readLine().split("");
            int cnt = 0;
            // 종료
            if(tmp[0].equals("-")){
                break;
            }
            
            //
            Stack<String> stack = new Stack<>();

            for(int i = 0; i<tmp.length; i++){
                // {이라면 stack에 무조건 넣기
                if(tmp[i].equals("{")) stack.add(tmp[i]);
                else {
                    if(!stack.isEmpty()) { // {이 stack에 존재한다면 꺼낸당
                        stack.pop();
                    }
                    else{ // 비어있다면 } => { 로 변경해서 넣어주기
                        stack.add("{");
                        cnt++; //변경횟수 늘리기
                    }
                }
            }
            // stack에 남아있는 친구들은 모두 { 괄호이므로 그 갯수의 절반만 변경하면
            // 완전한 문자열이 된다.
            sb.append(idx).append(". ").append(cnt + stack.size()/2).append("\n");
            
            // 출력문에 사용할 testcase 번호
            idx++;
        }
        System.out.println(sb);
    }
}
