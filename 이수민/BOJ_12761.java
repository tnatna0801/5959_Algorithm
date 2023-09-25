import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_12761 {
	static int a, b, n, m;
	static int[] visited = new int[100001];
	static int[] root;
	static int result;
	
	// 범위를 벗어나는지 확인하는 메소드
	static boolean boundaryCheck(int cur) {
		if (cur < 0 || cur > 100000) return false;
		else return true;
	}
	
	// bfs 탐색
	static void bfs() {
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		visited[n] = 1; // 방문 표시를 위해 1을 더하고 시작. 이후 정답 출력에서 1을 빼준 값 사용
		
		while(!queue.isEmpty()) {
			int pos = queue.poll();
			if (pos == m) return;
			
			for(int i=0; i<6; i++) {
				int cur = pos + root[i];
				if (!boundaryCheck(cur)) continue;
				
				if (visited[cur] == 0) {
					queue.offer(cur);
					visited[cur] = visited[pos] + 1;
				}
			}
			
			// 현 위치의 A배나 B배의 위치로 이동하는 경우 계산
			for(int i=6; i<8; i++) {
				int cur = pos*root[i];
				if (!boundaryCheck(cur)) continue;
				if (visited[cur] == 0) {
					queue.offer(cur);
					visited[cur] = visited[pos] + 1;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		root = new int[] {-1, 1, -a, a, -b, b, a, b};
		
		bfs();
		System.out.println(visited[m]-1);
	}
}
