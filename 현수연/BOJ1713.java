import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Candidate implements Comparable<Candidate> { // 후보 클래스입니다!
		private int num; // 후보 학생을 나타내는 고유번호
		private int score; // 후보 학생을 추천한 횟수 (제가 보기 편하게 점수로 명명했습니다)
		private int order; // 후보 학생이 추천된 순서 (작을수록 추천받은지 오래됨)

		public Candidate(int num, int score, int order) {
			this.num = num;
			this.score = score;
			this.order = order;
		}

		public int getNum() {
			return this.num;
		}

		public int getScroe() {
			return this.score;
		}
		
		public int getOrder() {
			return this.order;
		}

		@Override
		public int compareTo(Candidate o) { // 우선순위큐 삽입될 때 정렬되는 기준
			if (this.score == o.score) // 만일 추천을 동일한 횟수로 추천받았다면,
				return this.order - o.order; // 가장 오래된 순서대로 정렬 (오름차순) -> 가장 오래된 걸 먼저 빼야하니까
			return this.score - o.score; // 그 외의 경우 점수 오름차순 정렬 -> 가장 점수가 낮은 걸 먼저 빼야하니까
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 액자 수
		int M = Integer.parseInt(br.readLine()); // 추천 총 횟수
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Candidate> pq = new PriorityQueue<>(); // 액자에 올라간 후보들에 대한 우선순위 큐
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken()); // 추천받은 학생 번호
			boolean isExist=false; // 액자에 해당 학생번호가 있는지 없는지에 대한 boolean 값
			for(Candidate c : pq) { // forEach문으로 우선순위 큐에 있는 후보들을 검토합니다
				if(c.num==num) { // 만일 이미 액자에 있는 학생번호를 또 추천 받았다
					int score=c.getScroe(); // 그럴 경우 해당 후보의 현재 점수와 순서를 임시로 저장해둔 뒤,
					int order=c.getOrder();
					pq.remove(c); // 해당 후보를 지우고
					pq.offer(new Candidate(num, score+1, order)); // 점수를 하나 더 올려서 다시 우선순위 큐에 넣어줍니다
					isExist=true; // 이미 액자에 있었기 때문에 boolean값도 true로 해서 큐 검토를 마칩니다
					break;
				}
			}
			if(!isExist) { // 검토를 했는데 액자에 해당 후보가 없을 경우,
				if(pq.size()==N) // 액자가 다 찼으면 설정해둔 정렬순서에 따라 가장 우선순위가 높은 값을 한번 빼주고
					pq.poll();
				pq.offer(new Candidate(num, 1,i+1)); // 액자에 해당 후보를 새로운 순서로 채워줍니다.
			}
		}
		Candidate[] candidate = new Candidate[pq.size()]; // 최종 후보에 대한 액자 배열을 만들어줍니다
		// 여기서!!! 액자 개수만큼 후보를 추천받지 않을 수 있기 때문에 최종 후보는 우선순위 큐 사이즈만큼 배열로 만들어줍니다
		int idx = 0;
		while(!pq.isEmpty()) {
			candidate[idx++] = pq.poll(); 
		}
		Arrays.sort(candidate, new Comparator<Candidate>() { // 배열을 후보의 번호를 정렬합니다

			@Override
			public int compare(Candidate o1, Candidate o2) {
				return o1.num-o2.num; // 오름차순!
			}
			
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<idx;i++)
			sb.append(candidate[i].getNum()).append(" ");
		System.out.println(sb); // 최종 후보를 출력해줍니다.
	}
}
