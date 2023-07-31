import java.io.*;
import java.util.*;

public class BOJ11286 {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 람다식 써서 우선순위큐 선언
		PriorityQueue<Integer> pq = new PriorityQueue<>(N, (Integer o1, Integer o2) ->
			(Math.abs(o1) == Math.abs(o2) ? o1 - o2 : Math.abs(o1) - Math.abs(o2)));
		N = Integer.parseInt(br.readLine());
		int now;
		for(int i=0; i<N; i++) {
			now = Integer.parseInt(br.readLine());
			// 입력받은 값이 0이 아닐 때 우선순위큐에 데이터 저장
			if(now != 0) {
				pq.add(now);
			}
			// 입력받은 값이 0일 때 우선순위큐에서 데이터 꺼내서 출력
			else {
				// 우선순위큐가 비어있으면 0 출력
				if(pq.isEmpty()) {
					bw.write("0\n");
				}
				// 우선순위큐에서 꺼낸 값을 출력
				else {
					int test = pq.poll();
					bw.write(test+"\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}