import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] alpha;
	static int odd = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		alpha = new char[26];
		for (int i = 0; i < str.length(); i++)
			alpha[str.charAt(i) - 'A']++;
		boolean isPossible = true;
		for (int i = 0; i < 26; i++) {
			if (alpha[i] % 2 == 0)
				continue;
			if (odd == -1)
				odd = i;
			else {
				isPossible = false;
				break;
			}
		}
		if (isPossible) {
			for (int i = 0; i < 26; i++) {
				if (alpha[i] == 0)
					continue;
				for (int j = 0; j < alpha[i] / 2; j++)
					System.out.print((char) ('A' + i));
			}
			if (odd != -1)
				System.out.print((char) ('A' + odd));
			for (int i = 25; i >= 0; i--) {
				if (alpha[i] == 0)
					continue;
				for (int j = 0; j < alpha[i] / 2; j++)
					System.out.print((char) ('A' + i));
			}
		} else
			System.out.println("I'm Sorry Hansoo");
	}
}
