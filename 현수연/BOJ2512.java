import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int start = Integer.MAX_VALUE, end = 0, mid; // 첫 값, 마지막 값 초기화
		int budget[] = new int[N]; // 예산 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) { // 예산을 입력받습니다
			budget[i] = Integer.parseInt(st.nextToken());
			// 예산중 최댓값을 end에, 최솟값을 start에 넣어줍니다
			start = start < budget[i] ? start : budget[i];
			end = end > budget[i] ? end : budget[i];
		}
		// 총 예산을 입력받습니다
		int M = Integer.parseInt(br.readLine());
		// 상한가는 총 예산가/지방수로 초기화합니다
		int upperLimit=M/N;
		// 이분 탐색
		while (start <= end) {
			mid = (end + start) / 2;
			int sum = 0;
			for (int i = 0; i < N; i++) // mid값보다 작으면 해당 예산값을, mid값보다 크면 mid값으로 총 예산을 구합니다
				sum = sum + (budget[i] < mid ? budget[i] : mid);
			if (sum <= M) { // 총 예산보다 작으면 값을 저장한 뒤 이분탐색을 진행합니다
				upperLimit = mid;
				start = mid + 1;
			} else
				end = mid - 1;
		}
		System.out.println(upperLimit);
	}
}
