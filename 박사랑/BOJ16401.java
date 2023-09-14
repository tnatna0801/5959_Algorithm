import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16401 {

	static int M, N;
	static int[] L;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = new int[N];
		long total = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());
			total += L[i];
		}

		long max = total / M;
		if (max == 0 || max == 1) { // 과자 총 길이를 조카 수로 나눴을 때 1또는 0일 때
			System.out.println(max);
			return;
		}
		// 이분 탐색 시작
		long min = 2;
		long mid;
		long result = 1;
		Arrays.sort(L); // 오름차순 정렬
		while (min <= max) {
			mid = (min + max) / 2;
			if (chk(mid)) { // 현재 길이로 나눠주기 가능
				result = mid;
				min = mid + 1;
			} else { // 현재 길이로 나눠주기 불가능
				max = mid - 1;
			}
		}
		System.out.println(result);
	}

	public static boolean chk(long k) {
		int idx = N - 1;
		int leng = L[N - 1];
		int cnt = 0;
		while (cnt < M) {
			if (leng < k) { // 현재 과자에서 나눠줄 수 없음
				if (idx == 0) { // 현재 마지막 막대 과자임
					return false;
				}
				idx--;
				if (L[idx] < k) {
					return false; // 남은 막대 과자 길이가 k보다 작음
				}
				leng = L[idx];
			}
			cnt++;
			leng -= k;
		}
		return true;
	}
}
