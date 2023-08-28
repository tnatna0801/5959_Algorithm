import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2841 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int result = 0;

		// 스택 선언 & 초기화
		Stack<Integer>[] stack = new Stack[6];
		for (int i = 0; i < 6; i++) {
			stack[i] = new Stack<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken()) - 1;
			int fret = Integer.parseInt(st.nextToken());

			if (stack[line].isEmpty()) { // 스택이 비어 있을 때
				stack[line].add(fret);
				result++;
			}
			else if (stack[line].peek() < fret) { // fret이 peek보다 클 때
				stack[line].add(fret);
				result++;
			}
			else if (stack[line].peek() > fret) { // fret이 peek보다 작을 때
				// fret이 peek보다 커질때까지 pop해준다
				while (!stack[line].isEmpty() && stack[line].peek() > fret) {
					stack[line].pop();
					result++;
				}
				// fret을 push해준다
				if (stack[line].isEmpty() || stack[line].peek() != fret) {
					stack[line].add(fret);
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
