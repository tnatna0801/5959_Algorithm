import java.util.*;
import java.io.*;

public class BOJ1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			// 0열을 기준으로 정렬한다
			Queue<int[]> q = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
			
			// (서류 성적 순위, 면접 성적 순위)
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				q.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}
			
			int min = N;
			int count = 0;
			
			while(!q.isEmpty()) {
				int[] info = q.poll();
				
				if(min >= info[1]) {
					// 더 작거나 같은 수일 경우에만 카운트 한다
					count += 1;
					
					// 방문한 수 중 최솟값을 유지한다
					min = info[1];
				}
			}			
			sb.append(count+"\n");
		}		
		System.out.println(sb.toString());
	}	
}
