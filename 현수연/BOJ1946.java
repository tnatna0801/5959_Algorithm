import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1946 {
	// 채용 클래스 입니다. 서류심사와 면접심사 순위 값을 갖고있습니다
	static class Recruitment implements Comparable<Recruitment> {
		int document;
		int interview;

		public Recruitment(int document, int interview) {
			this.document = document;
			this.interview = interview;
		}

		public int getDocument() {
			return document;
		}

		public int getInterview() {
			return interview;
		}
		
		// 정렬 시 서류심사 순위 기준으로 오름차순합니다 
		@Override
		public int compareTo(Recruitment o) {
			return this.document - o.document;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		StringBuilder sb = new StringBuilder();
		for (int testcase = 0; testcase < T; testcase++) {
			int N = Integer.parseInt(br.readLine()); // 지원자 수
			Recruitment rec[] = new Recruitment[N]; // 지원자의 서류 및 면접 심사 배열
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int doc = Integer.parseInt(st.nextToken());
				int inter = Integer.parseInt(st.nextToken());
				rec[i] = new Recruitment(doc, inter);
			}
			Arrays.sort(rec); // 정렬 (서류 심사 기준 오름차순)
			// 서류 심사를 기준으로 오름차순으로 정렬을 진행한 후, 첫 지원자부터 마지막 지원자까지 면접 심사 순위를 비교합니다.
			int cnt = 1;
			int preInterview = rec[0].getInterview();
			for (int i = 1; i < N; i++) {
				// 이전 지원자의 심사 순위보다 클 경우
				if (rec[i].getInterview() > preInterview)
					continue; // 반복문 연산을 진행하지 않습니다
				// 이전 지원자의 심사 순위보다 낮을 경우
				preInterview = rec[i].getInterview(); //이전 지원자를 갱신하고
				cnt++; // 신입사원 카운팅을 합니다
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
