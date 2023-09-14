import java.io.*;
import java.util.*;

public class boj4889 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = 1;
		
		while (true) {
			// 문자열 입력
			String input = br.readLine();
			
			// 입력의 마지막 줄
			if (input.contains("-")) {
				break;
			}
			
			Stack<Character> stack = new Stack<>();

			for (int i=0; i<input.length(); i++) {
				char now = input.charAt(i);			
				
				// 안정적인 문자열 빼기
				if (!stack.isEmpty() && stack.peek() == '{' && now == '}') {
					stack.pop();
					continue;
				}
				
				stack.add(now);
			}
			
			int answer = 0;
			while (!stack.isEmpty()) {
				// 두 개씩 빼주기
				char s1 = stack.pop();
				char s2 = stack.pop();
				
				// '}}' or '{{' 인 경우 -> 한 번 바꾸면 된다.
				if (s1 == s2) {
					answer++;
					continue;
				}
				
				// '}{' 인 경우 -> 두 번 바꾸면 된다.
				answer += 2;
			}
			
			sb.append(t++).append(". ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

}
