import java.io.*;
import java.util.*;

public class boj2841 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 음의 수
		int p = Integer.parseInt(st.nextToken()); // 프렛의 수
		
		Stack<Integer>[] play = new Stack[7]; // 손가락의 위치를 저장?
		for (int i=1; i<7; i++) {
			play[i] = new Stack(); // 초기화
		}
		
		int answer = 0;
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken()); // 줄의 번호
			int b = Integer.parseInt(st.nextToken()); // 프렛의 번호
			
			// 더 큰 번호가 스택에 들어있을 경우 작거나 같아질 때까지 음을 뺀다.
			while (!play[a].isEmpty() && play[a].peek() > b) {
				play[a].pop();
				answer++;
			}
			
			// 스택이 비어있거나 스택에 들어있는 번호가 현재 번호보다 작을 경우 음을 넣는다.
			if (play[a].isEmpty() || play[a].peek() < b) {
				play[a].add(b);
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
