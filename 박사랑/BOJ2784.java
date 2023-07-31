import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2784 {

	static ArrayList<String> words, words_copy;
	static char[][] puzzle;
	static List<String> result_data;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		words = new ArrayList<>();
		words_copy = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			String input = br.readLine();
			words.add(input);
			words_copy.add(input);
		}

		result_data = new ArrayList<>();

		for (String s : words) {
			puzzle = new char[3][3];
			puzzle[0] = s.toCharArray();
			words_copy.remove(s);
			is_possible(0);
			words_copy.add(s);
		}

		if (result_data.size() == 0) { // 정답 값이 없을 때
			System.out.println(0);
			return;
		}
		
		String result = result_data.get(0);
		for (String tmp : result_data) { // 사전순으로 앞에 오는 값 찾기
			if (tmp.compareTo(result) < 0) {
				result = tmp;
			}
		}
		
		String r="";
		r+=result.charAt(0);
		r+=result.charAt(1);
		r+=result.charAt(2);
		System.out.println(r);
		r="";
		r+=result.charAt(3);
		r+=result.charAt(4);
		r+=result.charAt(5);
		System.out.println(r);
		r="";
		r+=result.charAt(6);
		r+=result.charAt(7);
		r+=result.charAt(8);
		System.out.println(r);
		
	}

	public static void print_puzzle() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(puzzle[i][j]);
			}
			System.out.println();
		}
	}

	public static void is_possible(int depth) {

		if (depth == 3) {
			String[] str = new String[3];
			List<String> add_str = new ArrayList<>();
			for (int i = 1; i < 3; i++) { // 1,2
				str[i] = "";
				str[i] += Character.toString(puzzle[i][0]);
				str[i] += Character.toString(puzzle[i][1]);
				str[i] += Character.toString(puzzle[i][2]);
				if (words_copy.contains(str[i])) {
					words_copy.remove(str[i]);
					add_str.add(str[i]);
				}
			}

			if (words_copy.size() == 0) { // 정답 일 때
				String result = "";
				for (int i = 0; i < 3; i++) {
					result += Character.toString(puzzle[i][0]);
					result += Character.toString(puzzle[i][1]);
					result += Character.toString(puzzle[i][2]);
				}
				result_data.add(result);
				for (String data : add_str) {
					words_copy.add(data);
				}
				return;
			} else { // 정답 아닐 때
				for (String data : add_str) {
					words_copy.add(data);
				}
				return;
			}
		}
		
		for (String s : words) {
			if (puzzle[0][depth] == s.charAt(0)) {
				puzzle[1][depth] = s.charAt(1);
				puzzle[2][depth] = s.charAt(2);
				if (words_copy.contains(s)) {
					words_copy.remove(s);
					is_possible(depth + 1);
					words_copy.add(s);
				}
			}
		}

	}

}
