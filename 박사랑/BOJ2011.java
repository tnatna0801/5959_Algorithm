import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ2011 {

	static final int MAX = 1000000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] pw = br.readLine().toCharArray();
		int[] dp = new int[pw.length];

		if (pw[0] == '0') { // 0으로 시작
			System.out.println(0);
			return;
		} else if(pw.length == 1) { // 암호 길이가 1
			System.out.println(1);
			return;
		}

		// 2와 같이 쓸 수 있는 문자
		Set<Character> possible = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6'));
		
		dp[0] = 1;
		
		if (pw[1] == '0') { // 두 번째 자리 0
			if (pw[0] == '1' || pw[0] == '2') { // 첫 번째 자리 1or2
				dp[1] = 1;
			} else {
				System.out.println(0);
				return;
			}
		}else if (pw[0] == '1') { // 11~19
			dp[1] = 2;
		} else if (pw[0] == '2' && possible.contains(pw[1])) { // 21~26
			dp[1] = 2;
		} else {
			dp[1] = 1;
		}

		for (int i = 2; i < pw.length; i++) {

			if (pw[i] == '0') {
				if (pw[i - 1] == '1' || pw[i - 1] == '2') {
					dp[i] = dp[i - 2];
				} else { // 안되는 경우 : 30,40 ... 90
					System.out.println(0);
					return;
				}
			} else if (pw[i - 1] == '0') {
				dp[i] = dp[i - 1];
			} else if (pw[i - 1] == '1') {
				dp[i] = dp[i - 1]  + dp[i - 2];
			} else if (pw[i - 1] == '2' && possible.contains(pw[i])) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1];
			}
			dp[i] %= MAX;
		}
		System.out.println(dp[pw.length - 1]);
	}
}
