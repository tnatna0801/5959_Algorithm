import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ1449 {

	static int N, L;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		L = Integer.parseInt(input[1]);

		List<Integer> pos = new ArrayList<>(); // 테이프 붙여야할 곳 위치 저장하는 리스트
		List<Integer> remain = new ArrayList<>(); // pos에서 테이프를 붙인 곳은 지우고 남은 곳을 저장하는 리스트

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(input[i]);
			pos.add(tmp);
			remain.add(tmp);
		}

		Collections.sort(pos); // 오름차순 정렬
		int result = 0;
		for (int i = 0; i < pos.size(); i++) {
			if (!remain.contains(pos.get(i))) { // 이미 테이트 붙인 곳 이면
				continue;
			}
			// 아니라면
			result++;
			int point = pos.get(i); // 테이프 처음 붙이기 시작하는 위치
			for (int j = 0; j < L; j++) { // 테이프 길이만큼 붙인다 -> 길이안에 포함되는 테이프 붙여야할 곳을 지움
				if (remain.contains(point + j)) {
					remain.remove(Integer.valueOf(point + j));
				}
			}
		}
		System.out.println(result);
	}
}
