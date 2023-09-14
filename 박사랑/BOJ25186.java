import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ25186 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, max, max_idx;
		int[] cnt;

		N = Integer.parseInt(br.readLine());
		cnt = new int[N];
		max = 0;
		max_idx = -1;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
			if (cnt[i] > max) {
				max = cnt[i];
				max_idx = i;
			}
		}

		// 예외 : 옷 종류가 한 개 일 때
		if (N == 1) {
			if (cnt[0] == 1) { // 한 명일 때
				System.out.println("Happy");
				return;
			} else { // 여러명일 때
				System.out.println("Unhappy");
				return;
			}
		}

		int sum = 0; // 개수 제일 많은 옷 빼고 나머지 옷 개수의 합
		for (int i = 0; i < N; i++) {
			if (i == max_idx) // 개수 제일 많은 옷 종류는 합하지 않음
				continue;
			sum += cnt[i];
			if (sum >= max) {
				System.out.println("Happy");
				return;
			}
		}
		System.out.println("Unhappy");
	}
}
