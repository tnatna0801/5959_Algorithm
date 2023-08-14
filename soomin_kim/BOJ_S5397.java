package w0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringBuilder sb = new StringBuilder();
			String[] array = br.readLine().split("");
			Stack<String> left = new Stack<>(); // 탐색할때 문자와 숫자를 넣을 stack
			Stack<String> right = new Stack<>(); // `<`나 `>` 일때 처리해줄 stack
			
			for(int i = 0; i<array.length; i++) { // 입력받은 문자열을 하나하나 탐색
				String current = array[i]; // 현재 문자 
				
				switch(current) {
				case "<": // < 이라면 커서를 왼쪽으로 이동해야한다. 
					if(!left.isEmpty()) // 이동해서 삽입을 할지 뭘할지 모르기때문에 pop해서 right stack에 임시저장해둔다.
						right.add(left.pop());
					break;
				
				case ">": // > 이라면 커서를 오른쪽으로 이동해야한다.
					if(!right.isEmpty()) //이때 이전에 <가 들어와서 임시저장해뒀던 원소들을 right stack에서 찾아와야한다!
						left.add(right.pop());
					break;
			
				case "-": // - 이라면 삭제해야하므로 간단하게 pop()해준다.
					if(!left.isEmpty())
						left.pop();
					break;
		
				default: // 문자 or 숫자 삽입
					left.add(current);
					break;
				}
	
			}
			
			while(!right.isEmpty()) { // 임시저장해둔 원소가 남아있다면 다 가져온다!!
				left.add(right.pop());
			}
			
			while(!left.isEmpty()) { // 찾아낸 비밀번호를 stack에서 가져온다.
				sb.append(left.pop());
			}
			sb.reverse(); // stack에서 꺼냈기 때문에 역순으로 정렬한다.
			System.out.println(sb);
		}
	}

}
