import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] value = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				value[i] = Integer.parseInt(st.nextToken());
			}

			int max = value[N - 1]; // 마지막 원소
			long result = 0;
			for (int i = N - 2; i >= 0; i--) {
				if (value[i] < max) {
					result += max - value[i];
				} else if (value[i] > max) {
					max = value[i];
				}
			}
			System.out.println(result);
		}
	}
}
