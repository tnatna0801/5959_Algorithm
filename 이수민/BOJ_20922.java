import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] count = new int[100001]; // 수열에 사용한 수 횟수 저장
		st = new StringTokenizer(br.readLine());
		int[] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int max=0, left=0, right=0;
		
		while(right < N) {
			
			// 현재보고 있는 위치의 수를 사용한 횟수가 K보다 적을 때
			if (count[a[right]] < K)
				count[a[right++]]++;
			else 
				count[a[left++]]--;
			

			// 현재 수열의 길이가 최댓값일 때 갱신
			if (max < right-left)
				max = right-left;
		}
		
		System.out.println(max);
	}
}
