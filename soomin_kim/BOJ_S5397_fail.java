package w0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_S5397_fail {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String[] array = br.readLine().split("");
			ArrayList<String> pwd = new ArrayList<>();

			int cursor = 0;
			for (int i = 0; i < array.length; i++) {
				String current = array[i];

				switch (current) {
				case "<":
					cursor--;
					if (cursor < 0)
						cursor = 0;
					break;

				case ">":
					cursor++;
					if (cursor > pwd.size())
						cursor = pwd.size();
					break;

				case "-":
					cursor--;
					if (cursor < 0) {
						cursor = 0;
						break;
					}
					pwd.remove(cursor);
					break;

				default: // 문자 or 숫자 삽입
					if (cursor < pwd.size()) {
						pwd.add(cursor, array[i]);
					} else
						pwd.add(array[i]);

					cursor++;
					break;
				}
			}
			
			String result = "";
			for (String s : pwd) {
				result += s;
			}
			sb.append(result).append("\n");

		}
		System.out.println(sb);

	}
}
