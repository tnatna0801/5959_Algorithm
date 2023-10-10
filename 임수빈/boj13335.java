import java.io.*;
import java.util.*;

public class boj13335 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Queue<Integer> bridge = new LinkedList<>(); // 다리에 있는 트럭들
		for (int i=0; i<w; i++) {
			bridge.add(0);
		}
		
		int weights = 0; // 다리에 있는 트럭들 무게의 합
		int answer = 0; // 모든 트럭들이 다리를 건너는 시간
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken()); // 트럭 입력
			int b = bridge.poll(); // 다리 제일 끝에 있는 값
						
			// 트럭이 다리 위에 올라갈 수 있는 경우
			if (weights + a <= l && b == 0) {
				bridge.add(a);
				weights += a;
				answer++;
				continue;
			}
			
			// 트럭이 다리 위에 올라갈 수 없는 경우
			while (weights - b + a > l || b != 0) {
				// 무게  X, 길이 O
				if (b == 0) {
					bridge.add(0);
					answer++;
					b = bridge.poll();
					continue;
				}
				
				// 무게 O, 길이 X
				if (weights - b + a <= l) {
					weights -= b;
					bridge.add(a);
					weights += a;
					answer++;
					break;
				}
				
				// 무게 X, 길이 X
				weights -= b;
				bridge.add(0);
				answer++;
				b = bridge.poll();
			}
		}
		
		// 남은 다리 길이만큼 더한다.
		answer += w;
		
		System.out.println(answer);
	}

}
