import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_4889 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		
		while(true) {
			char[] input = br.readLine().toCharArray();
			if (input[0] == '-') break;
			
			int stack=0; // 스택 안에 들어가는 건 언제나 '{'이기 때문에 int로 사용
			int result=0; // 현재 문자열 괄호 바꿔야 하는 수
			
			for(char c : input) {
				if (c == '{') {// 여는 괄호일 때
					stack++;
				}
				else { // 닫는 괄호일 때
					if (stack == 0) { // 스택에 아무것도 없다면
						result++; // 현재 문자를 바꿔서
						stack++; // 스택에 넣는다.
					}
					else { // 스택에 여는 괄호가 있다면
						stack--; // 스택에서 뺀다.
					}
				}
			}
			
			result += stack/2; // 남은 괄호의 반만 방향을 바꿔주면 된다.
			
			sb.append(cnt++).append(". ").append(result).append("\n");
			
		}
		
		System.out.println(sb);
	}
}
