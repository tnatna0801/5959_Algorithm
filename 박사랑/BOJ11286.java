import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 절댓값이 작은 값 > 더 작은 수
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			int abs_a = Math.abs(a);
			int abs_b = Math.abs(b);
			if (abs_a == abs_b) { // 절댓값은 같지만 a가 더 작은 수
				return a-b; // return 음수
			} else if (abs_a < abs_b) { // a가 절댓값이 더 작음
				return -1; // return 음수
			}else { // a가 절댓값이 더 큼
				return 1; // return 양수
			}
		});
		
		// 큐에서 빼내어 출력
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());

			if (input != 0) {
				pq.add(input);
			} else {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			}
		}
	}
}
