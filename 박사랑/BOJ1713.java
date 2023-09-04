import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1713 {

	static final int STUDENT = 100;

	static class Candidate {
		int student;
		int votes;
		int time;

		public Candidate(int student, int votes, int time) {
			this.student = student;
			this.votes = votes;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int cnt = 0; // 추천 순서

		PriorityQueue<Candidate> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.votes == o2.votes) // 투표수가 같으면 추천 순서로 비교
				return o1.time - o2.time;
			return o1.votes - o2.votes;
		});

		Candidate[] cd = new Candidate[STUDENT + 1]; // 1~100 학생 객체 생성
		for (int i = 1; i <= STUDENT; i++) {
			cd[i] = new Candidate(i, 0, -1);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int std = Integer.parseInt(st.nextToken());
			if (pq.contains(cd[std])) { // 학생이 사진 틀에 이미 있음
				pq.remove(cd[std]);
				cd[std].votes++;
				pq.add(cd[std]);
			} else { // 학생이 사진 틀에 없음
				if (pq.size() >= N) { // 우선순위 젤 작은거 out
					Candidate c = pq.poll();
					c.time = -1;
					c.votes = 0;
				}
				cd[std].votes = 1;
				cd[std].time = cnt++;
				pq.add(cd[std]); // 사진틀 넣기
			}
		}
		// 출력
		ArrayList<Integer> result = new ArrayList<>();
		for (Candidate c : pq) {
			result.add(c.student);
		}
		result.sort(null);
		for (int n : result) {
			System.out.print(n + " ");

		}
	}
}
