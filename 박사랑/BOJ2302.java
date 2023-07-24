
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2302 {

	static int N, M, result = 0, pos;
	static boolean[] isVIP;
	static int dp[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		isVIP = new boolean[N + 2];

		dp = new int[N + 2];

		// 1. isVIP에 VIP 좌석은 true로 입력
		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(br.readLine());
			isVIP[input] = true;
		}
		// 마지막 좌석 바로 뒤에 임의로 VIP 좌석을 두었음(구현 편리성)
		isVIP[N+1]=true;

		int cnt = 0;
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		pos = 2;
		result = 1;

		for (int i = 1; i < N + 2; i++) {
			if (isVIP[i]) { // VIP 좌석일 때
				if (dp[cnt] == 0) { // dp값이 채워져있지 않을 때
					fill_dp(cnt); // 필요한 만큼 dp를 채운다
				}
				result *= dp[cnt];
				cnt = 0;
			} else { // VIP 좌석아닐 때
				cnt++;
			}
		}

		System.out.println(result);

	}

	public static void fill_dp(int last) {
		if (last < 3)
			return;
		for (int i = pos; i <= last; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		pos = last + 1;
	}

}
