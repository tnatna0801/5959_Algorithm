import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BOJ5397 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			char[] input = br.readLine().toCharArray();
			Deque<Character> result = new ArrayDeque<>();
			Stack<Character> temp = new Stack<>();
			
			for(int i=0;i<input.length;i++) {
				char ch=input[i];
				if(ch=='<') {
					if(!result.isEmpty()) {
						temp.push(result.removeLast());
					}
				}else if(ch=='>') {
					if(!temp.isEmpty()) {
						result.addLast(temp.pop());
					}
				}else if(ch=='-') {
					if(!result.isEmpty()) {
						result.removeLast();
					}
				}else {
					result.addLast(ch);
				}
			}
			
			StringBuilder sb=new StringBuilder();
			while(!result.isEmpty()) {
				sb.append(result.pollFirst());
				
			}
			while(!temp.isEmpty()) {
				sb.append(temp.pop());
			}
			System.out.println(sb.toString());
		}
	}
}
