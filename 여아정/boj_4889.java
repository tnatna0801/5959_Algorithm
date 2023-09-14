package test_0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_4889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<>();
		// 안정적인 문자열 만들기=>최소 연산
		String input = null;

		int idx = 0;
		while (true) {// 문자열 입력 한줄씩 진행
			stack = new Stack<>();
			idx++;

			int cnt = 0;
			int len = 0;
			input = br.readLine();
			if (input.charAt(0) == '-') {// ---일 경우 입력이 끝남
				break;
			}

			char[] stable = input.toCharArray();
			len = stable.length;

			for (int i = 0; i < len; i++) {
				// stable[i]가 '{'이면 무조건 stack에 넣게됩니당~~~
				if (stable[i] == '{') {// {일 경우
					stack.push('{');// stack에 넣어 줍니다
				} else {// }일 겨우
					if (!stack.isEmpty()) {// 기존 stack에 '{'이 있다면
						stack.pop();// { }짝을 이뤘으니 pop해준다
					} else {// stack이 비어있다=>이전에 '{'가 없다 => 뭔가 잘못됐음
						// '{'로 바꿔서 stack에 넣어준다
						stack.push('{');
						cnt++;// 변경했으니 카운트를 추가한다
					}
				}
			}
			if (!stack.isEmpty()) {// for문을 모두 다 끝나고 stack에 값이 남아있다면
				// 남아있다면 {{만 남아있다는 소리!!!
				cnt += stack.size() / 2;// stack.size()/2로 카운트를 추가한다!!
			}
			sb.append(idx + ". " + cnt).append("\n");
		}
		System.out.println(sb.toString());

	}

}