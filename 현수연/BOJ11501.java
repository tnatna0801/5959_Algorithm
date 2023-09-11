import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {
	static long stock[];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine()); // 날의 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			stock = new long[N]; // 주식 배열
			long max = 0; // 주식 배열 중 가장 큰 값
			int maxIdx = -1; // 가장 큰 값의 인덱스 값
			for (int j = 0; j < N; j++) { // 우선 전체 인덱스에서 가장 큰 값과 해당 값의 인덱스를 구합니다
				stock[j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, stock[j]);
				if (max == stock[j])
					maxIdx = j;
			}
			long sum = profit(0, maxIdx, 0, 0); // 가장 큰 값을 이용하여 주식을 최대 이익으로 끌어올릴 수 있는 함수를 사용합니다
			sb.append(sum).append("\n"); // 테스트 케이스 마다 출력 값을 저장합니다
		}
		System.out.println(sb); // 결과 값을 출력합니다
	}

	static long profit(int startIdx, int maxIdx, long sum, int cnt) {
		if(cnt==N) // 마지막 주식까지 도달할 경우, 최종 최대 이익 값을 출력합니다
			return sum;
		for(int i=startIdx; i<maxIdx;i++) { // 우선 첫 시작 인덱스부터, 최대 값이 나온 인덱스까지
			sum+=stock[maxIdx]-stock[i]; // 최대값과의 차를 모두 더해줍니다
		}
		startIdx = maxIdx+1; // 이제 최대값 이후의 인덱스를 다시 첫 시작 인덱스로 만들어주고
		long max = 0;
		for(int i=startIdx;i<N;i++) { // 그 이후의 최댓값을 새로 구해줍니다
			max=Math.max(max, stock[i]);
			if(max==stock[i])
				maxIdx=i;
		}
		return profit(startIdx, maxIdx, sum, startIdx); // 위와 같은 연산을 재귀로 반복해주면 최종적으로 최대 이익값이 도출됩니다
	}
}
