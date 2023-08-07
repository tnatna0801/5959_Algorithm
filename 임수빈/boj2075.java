import java.io.*;
import java.util.*;

public class boj2075 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		
		// 우선순위 큐 (내림차순)
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i=0; i<n; i++) {
			// 입력 받은 숫자를 바로 큐에 넣는다.
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<n; j++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int answer = 0;
		
		// n번째 큰 수가 나올 때까지 큐에서 값을 꺼낸다.
		for (int i=0; i<n; i++) {
			answer = queue.poll();
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}

}
