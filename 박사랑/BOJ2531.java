import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2531 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N, d, k, c;
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int[] chobab = new int[d + 1]; // 초밥 종류 1~d가 몇개인가
		int[] belt = new int[N]; // 벨트위의 초밥
		int kind_cnt = 0; // 포함 종류 몇가지
		int first_chobab = belt[0]; // 연속된 k개 중에서 첫번째 초밥
		// 쿠폰있는 초밥 추가
		chobab[c] += 1;
		kind_cnt++;

		for (int i = 0; i < N; i++) { // 벨트 위 초밥 입력받자
			belt[i] = Integer.parseInt(br.readLine());
			if (i < k) { // 첫 초밥 쌍
				chobab[belt[i]] += 1;
				if (chobab[belt[i]] == 1)
					kind_cnt++;
			}
		}
		
		int answer = kind_cnt;

		for (int i = 1; i < N; i++) { // 벨트 위 i=1 부터 슬라이딩
			 first_chobab = belt[i-1];
			if (chobab[first_chobab] == 1) { // 한개 있는 초밥
				kind_cnt--; // 종류 빼
			}
			chobab[first_chobab]--; // 첫번째 초밥 갯수 빼
			int next_chobab = belt[(i + k - 1) % N]; // 다음 초밥
			if (chobab[next_chobab] == 0) { // 처음 먹는 초밥
				kind_cnt++; // 종류 더해주자
			}
			chobab[next_chobab]++;
			answer = Math.max(answer, kind_cnt);
		}
		System.out.println(answer);
	}
}
