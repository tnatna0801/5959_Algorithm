import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {

	static int total, N;
	static int[] budget;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 지방의 수
		budget = new int[N]; // 각 지방의 예산 요청
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0; // 각 지방 예산 요청 중에 제일 큰 값
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, budget[i]);
		}
		total = Integer.parseInt(br.readLine()); // 총 예산
		int result = 0; // 상한액의 최댓값
		// 이분 탐색 시작
		int min = 1;
		while (min <= max) {
			int mid = (min + max) / 2;
			if (cal(mid)) { // 현재 예산으로 가능
				min = mid + 1;
				result = mid;
			} else { // 현재 예산으로 불가능
				max = mid;
				if(min==max) break;
			}
		}
		System.out.println(result);
	}

	public static boolean cal(int max) {
		int t = total;
		for (int i = 0; i < N; i++) {
			if (budget[i] >= max) { // 예산 요청이 상한액보다 큼
				t -= max;
			} else { // 예산 요청이 상한액보다 작음
				t -= budget[i];
			}
			if (t < 0)
				return false; // 예산이 부족함 -> 배정 불가능
		}
		return true; // 배정 가능
	}
}
