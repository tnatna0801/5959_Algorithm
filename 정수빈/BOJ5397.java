import java.io.*;
import java.util.*;

public class BOJ5397{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		// 테스트 케이스 개수 T
		int T = Integer.parseInt(br.readLine());
		// 커서를 기준으로 하는 왼쪽 스택, 오른쪽 스택
		Stack left, right;
		
		for(int t=1; t<=T; t++) {
			sb = new StringBuilder();
			String s = br.readLine();
			left = new Stack();
			right = new Stack();
			
			for(char c : s.toCharArray()) {
				// 화살표 == < >
				// 커서의 위치 1만큼 움직임
				switch(c) {
					case '<':
						if(left.isEmpty())
							continue;
						
						// 왼쪽에 있는 값을 오른쪽으로 옮김
						right.push(left.pop());
						break;
					case '>':
						if(right.isEmpty())
							continue;
						
						// 오른쪽에 있는 값을 왼쪽으로 옮김
						left.push(right.pop());
						break;
					// 백스페이스 == -
					// 커서 바로 앞에 글자가 존재하면 그 글자를 지운다
					case '-':
						if(left.isEmpty())
							continue;
						
						left.pop();
						break;
					// 나머지는 비밀번호의 일부
					default:
						left.push(c);
				}
			}
			
			while(!left.isEmpty())
				sb.append(left.pop());
			sb.reverse();
			
			while(!right.isEmpty())
				sb.append(right.pop());
			
			System.out.println(sb.toString());
		}
	}
}
