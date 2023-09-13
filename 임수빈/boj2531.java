import java.io.*;
import java.util.*;

public class boj2531 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		// 초밥 입력받기
		int[] input = new int[n+k-1];
		for (int i=0; i<n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		// 회전 초밥 -> 끝에 k-1개 추가
		for (int i=0; i<k-1; i++) {
			input[i+n] = input[i];
		}
		
		int[] visited = new int[d+1]; // 고른 초밥의 종류
		int cnt = 0; // 초밥의 가짓수
		
		for (int i=0; i<k; i++) {
			// 새로 추가되는 초밥이면 초밥의 가짓수 추가
			if (visited[input[i]] == 0) {
				cnt++;
			}
			// 초밥 넣기
			visited[input[i]]++;
		}
		
		// 쿠폰이 포함되어 있으면 그대로, 포함되어 있지 않으면 추가해서 저장
		int answer = (visited[c] == 0)? cnt+1 : cnt;
		
		for (int i=0; i<n-1; i++) {
			// 맨 앞 초밥 빼기
			visited[input[i]]--;
			
			// 해당 초밥이 모두 빠졌으면 초밥의 가짓수 감소
			if (visited[input[i]] == 0) {
				cnt--;
			}
			
			// 새로 추가되는 초밥이면 초밥의 가짓수 추가
			if (visited[input[i+k]] == 0) {
				cnt++;
			}
			
			// 초밥 넣기
			visited[input[i+k]]++;
			
			// 최댓값 갱신
			answer = (visited[c] == 0)? Math.max(answer, cnt+1) : Math.max(answer, cnt);
		}
		
		System.out.println(answer);
	}

}
