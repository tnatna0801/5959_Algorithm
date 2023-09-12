import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16401 {
	
	static int M, N;
	static long[] L;
	static long min = 1;
	static long max = 1000000000;
	static long result;
	
	// 과자 나누기
	static boolean divideSnack(long mid) {

		int idx = 0;
		int cur = 0;
		while(true) {
			if (idx == N) break;
			
			cur += L[idx]/mid;
			
			if (cur >= M) return true;
			
			idx++;
		}
		
		return false;
	}
	
	// 이분 탐색
	static void binarySearch() {
		while(min <= max) {
			long mid = (min + max)/2; // 중간값
			
			// mid길이로 과자를 나눌 때, 모든 조카들에게 돌아간다면 과자 길이를 더 늘려봐도 됨
			if (divideSnack(mid)) {
				min = mid + 1;
				result = mid;
			}
			else { // 모든 조카들에게 과자를 균등하게 나누지 못한다면 길이를 줄여야 함.
				max = mid - 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = new long[N];
		
		
		st =  new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			L[i] = Integer.parseInt(st.nextToken());
	
		
		binarySearch();
		System.out.println(result);
		
	}
}
