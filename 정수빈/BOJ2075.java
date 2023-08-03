import java.util.*;
import java.io.*;

public class BOJ2075 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

    // 우선 순위 큐 (내림차순)
		Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		int N =  Integer.parseInt(br.readLine());

    // 일렬로 입력 받음
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				q.add(Integer.parseInt(st.nextToken()));
		}

    // N 번째 값 이전까지 버리고, N 번째 값 출력
		while(--N > 0)
			q.remove();
		System.out.println(q.peek());
	}
}
