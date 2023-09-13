import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 조카 수
		int N = Integer.parseInt(st.nextToken()); // 과자 개수
		st = new StringTokenizer(br.readLine());
		int[] L = new int[N]; // 과자별 길이 배열
		int max=0; // 가장 길이가 긴 과자의 길이
		for (int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(st.nextToken());  // 과자별 길이를 입력받으면서
			max = Math.max(max, L[i]); // 가장 긴 길이를 구해줍니다
		}
		int start = 1; // 과자 길이의 최소값을 시작값으로
		int end = max; // 과자 길이의 최대값을 끝값으로 설정하여
		int ans = 0; // (조카들에게 최대한 많은 길이를 줄 수 있는 정답 변수입니다)
		while (start <= end) { // 이진탐색을 시작합니다
			int mid = start + (end - start) / 2; // mid 값 갱신
			int sum = 0; // 과자개수의 총 합
			for(int i=0;i<N;i++)
				sum+=L[i]/mid; // 과자 길이별로 놔눠줄 수 있는 과자 개수의 총합을 구하여
			if (sum>=M) { // 조카의 수 보다 많을 경우
				ans = mid; // 답은 mid로 갱신
				start = mid + 1; // 시작 값은 mid+1로 갱신
			} else // 조카의 수보다 적을 경우
				end = mid - 1; // 끝 값을 mid-1로 갱신
		}
		
		System.out.println(ans); // ans 출력
	}
}
