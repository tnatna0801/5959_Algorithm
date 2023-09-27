import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 지원자의 성적 순위를 정보를 갖는 클래스
class Applicant implements Comparable<Applicant>{
	int document;
	int interview;
	
	Applicant(int document, int interview){
		this.document = document;
		this.interview = interview;
	}

	// 서류 심사 성적을 토대로 정렬
	public int compareTo(Applicant o) {
		return Integer.compare(this.document, o.document);
	}	
}

public class BOJ_1946 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Applicant> applicants = new PriorityQueue<>();

			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				applicants.offer(new Applicant(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			int result = 0;
			int highGrade=n; // 현재 가장 높은 면접 순위를 저장
			while(!applicants.isEmpty()) {
				// 현재 지원자의 면접 성적 순위
				int curGrade = applicants.poll().interview;
				
				// 현재 순위가 이제까지 순위들보다 더 높다면
				if (curGrade <= highGrade) {
					result++;
					highGrade = curGrade; // 값을 갱신
				}
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
