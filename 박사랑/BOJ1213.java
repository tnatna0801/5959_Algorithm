import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BOJ1213 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] name = br.readLine().toCharArray();

		int[] alpha = new int[26];

		for (int i = 0; i < name.length; i++) {
			char ch = name[i];
			alpha[ch - 'A']++;
		}

		int odd = 0; // 홀수 갯수
		int odd_idx = 0; // 홀수 인덱스
		for (int i = 0; i < 26; i++) {
			if (alpha[i] % 2 == 1) {
				odd++;
				odd_idx = i;
			}
		}

		int length = name.length;

		if (length % 2 == 0 && odd > 0) { // 짝수길이인데 홀수가 있을 때
			System.out.println("I'm Sorry Hansoo");
			return;
		} else if (odd > 1) { // 홀수가 2개 이상 있을 때
			System.out.println("I'm Sorry Hansoo");
			return;
		} else { // 성공하는 경우
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < alpha[i] / 2; j++) {
					System.out.print((char) (i + 'A'));
				}
			}
			if (odd == 1) { // 홀수가 있다면??
				System.out.print((char) (odd_idx + 'A'));
			}
			for (int i = 25; i >= 0; i--) {
				for (int j = 0; j < alpha[i] / 2; j++) {
					System.out.print((char) (i + 'A'));
				}
			}
		}
	}
}
