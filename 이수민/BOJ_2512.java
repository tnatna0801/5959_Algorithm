import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {
	static int n, m;
	static int[] budgets;
	static int min = 1, max = 1;
	static int result;
	
	// 현재 mid값으로 예산을 배정할 수 있는지 체크
	static boolean check(int mid) {
		int sum=0;
		for(int b: budgets) {
			// mid보다 작다면, 그 만큼의 예산만 배정하면 됨.
			sum += b > mid ? mid : b;
			if (sum > m) return false; // 배정할 수 없음
		}
		return true;
	}
	
	static void binarySearch() {
		while(min <= max) {
			int mid = (min+max)/2;
			
			if (check(mid)) {
				// 배정할 수 있으면, 예산의 최댓값을 찾기 위해 금액을 좀 더 키워볼 수 있다.
				min = mid+1;
				result = mid;
			}
			else {
				// 배정할 수 없으면, 금액을 줄여봐야 한다.
				max = mid-1;
			}	
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		budgets = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, budgets[i]); // 예산요청 중 가장 큰 값이 최대
		}
		m = Integer.parseInt(br.readLine());
		
		// 이분 탐색
		binarySearch();
		System.out.println(result);
	}
}
