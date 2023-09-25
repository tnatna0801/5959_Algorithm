import java.io.*;
import java.util.*;

public class boj12761 {

	static int A, B;
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		System.out.println(bfs());
	}
	
	static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {N, 0}); // 동규 위치, 이동 횟수
		
		boolean[] visited = new boolean[100001];
		visited[N] = false;
		
		while (!queue.isEmpty()) {
			int q[] = queue.poll();
			int pos = q[0];
			int cnt = q[1];
			
			// 주미 위치 도달
			if (pos == M) {
				return cnt;
			}
			
			// 이동 위치가 범위 안에 있고, 방문한 적이 없으면 방문한다.
			if (pos*A <= 100000 && !visited[pos*A]) {
				visited[pos*A] = true;
				queue.add(new int[] {pos*A, cnt+1});
			}
			
			if (pos*B <= 100000 && !visited[pos*B]) {
				visited[pos*B] = true;
				queue.add(new int[] {pos*B, cnt+1});
			}
			
			if (pos+A <= 100000 && !visited[pos+A]) {
				visited[pos+A] = true;
				queue.add(new int[] {pos+A, cnt+1});
			}
			
			if (pos+B < 100000 && !visited[pos+B]) {
				visited[pos+B] = true;
				queue.add(new int[] {pos+B, cnt+1});
			}
			
			if (pos-A >= 0 && !visited[pos-A]) {
				visited[pos-A] = true;
				queue.add(new int[] {pos-A, cnt+1});
			}
			
			if (pos-B >= 0 && !visited[pos-B]) {
				visited[pos-B] = true;
				queue.add(new int[] {pos-B, cnt+1});
			}
			
			if (pos+1 <= 100000 && !visited[pos+1]) {
				visited[pos+1] = true;
				queue.add(new int[] {pos+1, cnt+1});
			}
			
			if (pos-1 >= 0 && !visited[pos-1]) {
				visited[pos-1] = true;
				queue.add(new int[] {pos-1, cnt+1});
			}
		}
		
		return 0;
	}

}
