import java.io.*;
import java.util.*;

public class boj11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 연산의 개수
		int n = Integer.parseInt(br.readLine());
		
		// 우선순위 큐 - 절댓값으로 정렬
		PriorityQueue<Integer> queue = new PriorityQueue<>(new AbsComparator());
		
		// 정답 리스트
		List<Integer> answer = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (x == 0) { // 정답 리스트에 큐가 비어있으면 0, 비어있지 않으면 해당 값 삽입
				int res = 0;
				if (!queue.isEmpty()) {
					res = queue.poll();
				}
				answer.add(res);
			} else { // 큐에 정수 삽입
				queue.add(x);
			}
		}
		
		// 정답 출력
		for (int i : answer) {
			bw.write(i + "\n");
		}
		
		bw.flush();
		bw.close();

	}
	
	public static class AbsComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// 절댓값이 더 크면 1 리턴
			if (Math.abs(o1) > Math.abs(o2)) {
				return 1;
			}
			
			// 절댓값이 더 작으면 -1 리턴
			if (Math.abs(o1) < Math.abs(o2)) {
				return -1;
			}

			// 절댓값이 같고, 값이 더 크면 1 리턴
			if (o1 > o2) {
				return 1;
			}
			
			// 절댓값이 같고, 값이 더 작으면 -1 리턴
			return -1;
		}
		
	}

}
