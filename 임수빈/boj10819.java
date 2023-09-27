import java.io.*;
import java.util.*;

public class boj10819 {

	static int n;
	static int[] a;
	
	static int answer = 0;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		a = new int[n];
		visited = new boolean[n];
		result = new int[n]; // 순열을 저장할 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		permutations(0);
		System.out.println(answer);

	}
	
	static void permutations(int cnt) {
		// 순열 만들기 완료
		if (cnt == n) {
			int sum = 0;
			
			// 합 구하기
			for (int i=1; i<n; i++) {
				sum += Math.abs(result[i-1] - result[i]);
			}
			
			// 최댓값 갱신
			answer = Math.max(answer, sum);
			return;
		}
		
		for (int i=0; i<n; i++) {
			if (visited[i]) {
				continue;
			}
			
			result[cnt] = a[i];
			visited[i] = true;
			permutations(cnt+1);
			visited[i] = false;
		}
	}

}
